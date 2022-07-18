package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@Data
@ToString
@NoArgsConstructor
public class UserInfo {

    private String userName;

    private String name;

    private String surname;

    private Date dateOfBirth;


    public UserInfo(String userName, String name, String surname, Date dateOfBirth) {
        this.userName = userName;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }
}
