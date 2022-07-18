package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "education")

@NamedQueries({

        @NamedQuery(name = "Education.findEducation" , query = "select e from Education  e ") ,
        @NamedQuery(name = "Education.findEducationById" , query = "select e from Education  e where e.educationId = :id ") ,
        @NamedQuery(name = "Education.findEducationByIdWithAdvertisement" , query = "select e from Education  e left join fetch e.advertisementList where e.educationId = :id")
})


public class Education implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_id")
    private Integer educationId;

    @Column(name = "education_name")
    private String educationName;

    @Column(name = "lisans_year")
    private int lisansYear;


    @ManyToMany(mappedBy = "educations" , fetch = FetchType.LAZY)
    private List<Advertisement> advertisementList;

    @Override
    public String toString() {
        return "Education{" +
                "educationId=" + educationId +
                ", educationName='" + educationName + '\'' +
                ", lisansYear=" + lisansYear +
                ", advertisementList=" + advertisementList +
                '}';
    }
}
