package com.company.test;

import com.company.factory.Factory;
import com.company.model.User;
import com.company.repository.inter.UserRepo;
import com.company.repository.impl.UserImpl;

import java.util.Date;


public class HibernateTest implements Factory {
    public static void main(String[] args) {


        UserRepo userRepo = new UserImpl();
        User user = new User(null,"GurbanAlizada" ,"12345678" , new Date() , null);
        userRepo.saveUser(user);


    }
}
