package com.company.test;

import com.company.factory.Factory;
import com.company.model.*;
import com.company.model.util.PhoneType;
import com.company.repository.inter.AdvertisementRepo;
import com.company.repository.inter.UserRepo;
import com.company.repository.impl.UserImpl;
import com.company.service.impl.AdvertisementServiceImpl;
import com.company.service.impl.EducationServiceImpl;
import com.company.service.impl.UserDetailServiceImpl;
import com.company.service.impl.UserServiceImpl;
import com.company.service.inter.AdvertisementService;
import com.company.service.inter.EducationService;
import com.company.service.inter.UserDetailService;
import com.company.service.inter.UserService;

import java.util.*;


public class HibernateTest implements Factory {
    public static void main(String[] args) {


        /*
        // EducationService
        EducationService educationService = new EducationServiceImpl();
      //  System.out.println(educationService.findAllEducation());
        System.out.println(educationService.findEducationByIdWithAdvertisement(1));
        */

        /*
        // AdvertisementService
        AdvertisementService advertisementService = new AdvertisementServiceImpl();
        //System.out.println(advertisementService.findAllAdvertisements());
        System.out.println(advertisementService.findById(1));
       */


/*
        UserDetailService userDetailService = new UserDetailServiceImpl();
        System.out.println(userDetailService.findAddressByUsername("VolkanDemirel"));
*/


/*
        // UserService Methods
       UserService userService = new UserServiceImpl();
       //System.out.println(userService.findUserById(1L));
      //  System.out.println(userService.findUsernameWithDetail("VolkanDemirel"));
        // System.out.println(userService.findUserInfo());
       // System.out.println(userService.findUserCount());
*/




/*
        // SaveMethods
        UserService userService = new UserServiceImpl();

        Map<PhoneType , String> map = new HashMap<>();
        map.put(PhoneType.WORK , "+9940503336699");

        List<Address> addresses = new ArrayList<>();
        addresses.add(new Address("Besiktas" , "12" , "Istanbul" , "034"));
        addresses.add(new Address("Kadikoy" , "74" , "Istanbul" , "034"));

        List<String> emails = new ArrayList<>();
        emails.add("vk1@gmail.com");
        emails.add("vk001@gmail.com");

       List<Education> educations = new ArrayList<>();
        educations.add(new Education(null , "Master" , 4 ,null));

      //  List<Advertisement> advertisements = new ArrayList<>();
      //  advertisements.add(new Advertisement(null , "Java Developer" , "3 Year Experience" ,"Software Knowledge" , new Date() ,null , null , false , educations , null));


        UserDetail userDetail = new UserDetail(null , "VolKan" , "Demirel" ,new Date() , map , addresses , emails , null ,null  );

        User user = new User(null,"VolkanDemirel" ,"FB1907" , new Date() , userDetail);
        userService.saveUser(user);


        AdvertisementService advertisementService = new AdvertisementServiceImpl();
        advertisementService.saveAdvertisement(new Advertisement(null , "Java Developer" , "3 Year Experience" ,"Software Knowledge" , new Date() ,null , null , false , educations , null));
*/


    }
}
