package com.company.repository.inter;

import com.company.model.Advertisement;
import com.company.model.User;
import com.company.model.UserInfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public interface UserRepo {


    boolean saveUser(User user);

    boolean updateUser(User user);

    boolean removeUser(User user);


    User findUserById(Long id);

    List<User> findAllUserWithDetail();

    User findUsernameWithDetail(String username);

    List<UserInfo> findUserInfo();


    UserInfo findUserInfoByUsername();

    long findUserCount();
}
