package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name ="User.findUserInfo" , query = "select new com.company.model.UserInfo(u.userName , u.userDetail.firstName , u.userDetail.surName ,u.userDetail.dateOfBirth) from User u"),
        @NamedQuery(name ="User.findUserInfoByUsername" , query = "select new com.company.model.UserInfo(u.userName , d.firstName , d.surName ,d.dateOfBirth) from User u left join u.userDetail d where u.userName = :username"),
        @NamedQuery(name="User.findAllUser" , query = "select u from User u"),
        @NamedQuery(name="User.findAllUserWithDetail" , query = "select u from User u left join fetch u.userDetail"),
        @NamedQuery(name = "User.findUserById" , query = "select u  from User u  where u.userId = :id") ,
        @NamedQuery(name = "User.findUserByIdWithDetail" , query = "select u  from User u left join fetch u.userDetail where u.userId = :id") ,
        @NamedQuery(name = "User.findUsername" , query = "select u from User u where u.userName = :username"),
        @NamedQuery(name = "User.findUsernameWithDetail" , query = "select u from User u left join fetch u.userDetail where u.userName = :username"),
        @NamedQuery(name ="User.findUserCount" , query = "select count(u) from User u ") ,
        @NamedQuery(name ="User.findUserInfo2" , query = "select new com.company.model.UserInfo(u.userName , u.userDetail.firstName , u.userDetail.surName ,u.userDetail.dateOfBirth) from User u")
})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName ;

    @Column(name = "password" , length = 255)
    private String password;

    @Column(name ="creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_detail_id")
    private UserDetail userDetail;



}
