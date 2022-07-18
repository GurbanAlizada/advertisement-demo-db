package com.company.model;

import com.company.model.util.PhoneType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "userdetail")

@NamedQueries({
        @NamedQuery(name = "UserDetail.findByUserName" , query = "select ud from UserDetail ud where ud.user.userName = :username") ,
        @NamedQuery(name = "UserDetail.findByUserName2" , query = "select ud from UserDetail ud left join fetch ud.user u where u.userName = :username") ,
        @NamedQuery(name = "UserDetail.findAddressByUsername" , query = "select ud from UserDetail ud left join fetch ud.addressesrres  where ud.user.userName = :username" ),
        @NamedQuery(name = "UserDetail.findAddressByUsername2" , query = "select ud from UserDetail ud left join fetch ud.addressesrres a  left join fetch ud.user u where u.userName = :username" ),
        @NamedQuery(name ="User.Detail.findAdvertisementByUserName" , query = "select ud from UserDetail  ud left join fetch ud.advertisements  where ud.user.userName = :username") ,
        @NamedQuery(name ="User.Detail.findAdvertisementByUserName2" , query = "select ud from UserDetail  ud left join fetch ud.advertisements a left join fetch ud.user  where ud.user.userName = :username") ,
        @NamedQuery(name ="User.Detail.findPhoneNumbersByUsername" , query = "select ud from UserDetail  ud left join fetch ud.phoneNumbers p left join fetch ud.user u where u.userName = :username") ,
        @NamedQuery(name ="User.Detail.findEmailsByUserName" , query = "select ud from UserDetail  ud left join fetch ud.emails e left join fetch ud.user u where u.userName = :username")
})


public class UserDetail implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_detail_id")
    private Long userDetailId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String surName;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;


    @ElementCollection(fetch = FetchType.LAZY)
    @JoinTable(name = "userdetail_phonenumbers" , joinColumns = @JoinColumn(name = "user_detail_id"))
    @MapKeyColumn(name = "phone_types" )
    @JoinColumn(name = "phone_number")
    private Map<PhoneType , String> phoneNumbers = new HashMap<>();


    @ElementCollection(fetch = FetchType.LAZY)
    @JoinTable(name = "userdetail_addresses" , joinColumns = @JoinColumn(name = "user_detail_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "street" , column = @Column(name = "town"))
    })
    private List<Address> addressesrres = new ArrayList<>();


    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "users_emails" , joinColumns = @JoinColumn(name = "personal_id"))
    @Column(name = "emails" , length = 55)
    private List<String> emails = new ArrayList<>();



    @OneToMany(mappedBy = "userDetail" , fetch = FetchType.LAZY)
   private List<Advertisement> advertisements ;



    @OneToOne(mappedBy = "userDetail" , fetch = FetchType.LAZY)
    private User user ;


}
