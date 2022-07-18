package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "advertisement")

@NamedQueries({
        @NamedQuery(name = "Advertisement.findById" , query = "select a from Advertisement a left join a.educations where a.advertisementId = :id"),
        @NamedQuery(name = "Advertisement.findByUsername" , query = "select  a from User u left join u.userDetail ud left join ud.advertisements a where u.userName = :username"),
        @NamedQuery(name= "Advertisement.findAll" , query = "select a from Advertisement  a")
})


public class Advertisement  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "advertisement_id")
    private Integer advertisementId;

    @Lob
    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "criteria")
    private String criteria ;

    @Lob
    @Column(name = "work_definition")
    private String workDefinition;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "add_date")
    private Date addDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    private Date updateDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "remove_date")
    private Date removeDate;

    @Column(name = "enabled")
    private boolean enabled = false;


    @ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.PERSIST)
    @JoinTable(name = "advertisement_education" ,
            joinColumns = @JoinColumn(name = "advertisement_id") ,
            inverseJoinColumns = @JoinColumn(name = "education_id"))
    private List<Education>  educations = new ArrayList<Education>();

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_detail_id")
    private UserDetail userDetail;


    @Override
    public String toString() {
        return "Advertisement{" +
                "advertisementId=" + advertisementId +
                ", title='" + title + '\'' +
                ", criteria='" + criteria + '\'' +
                ", workDefinition='" + workDefinition + '\'' +
                ", addDate=" + addDate +
                ", updateDate=" + updateDate +
                ", removeDate=" + removeDate +
                ", enabled=" + enabled +
              //  ", educations=" + educations +
              //  ", userDetail=" + userDetail +
                '}';
    }
}
