package com.company.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {


    @Column(name = "street")
    private String street ;

    @Column(name = "road")
    private String road ;

    @Column(name = "city")
    private String city;

    @Column(name = "post_code")
    private String postCode;

}
