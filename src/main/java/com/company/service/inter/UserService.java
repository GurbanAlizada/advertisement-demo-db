package com.company.service.inter;

import com.company.model.User;
import com.company.model.UserInfo;

import java.util.List;

public interface UserService {


    boolean saveUser(User user);

    boolean updateUser(User user);

    boolean removeUser(User user);


    User findUserById(Long id);

    List<User> findAllUserWithDetail();

    User findUsernameWithDetail(String username);

    List<UserInfo> findUserInfo();


    UserInfo findUserInfoByUsername();

    int findUserCount();
}
