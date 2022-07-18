package com.company.service.impl;

import com.company.model.User;
import com.company.model.UserDetail;
import com.company.model.UserInfo;
import com.company.repository.impl.UserImpl;
import com.company.repository.inter.UserRepo;
import com.company.service.inter.UserDetailService;
import com.company.service.inter.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepo userRepo = new UserImpl();

    @Override
    public boolean saveUser(User user) {
        boolean b = userRepo.saveUser(user);
        return b;
    }

    @Override
    public boolean updateUser(User user) {
        return this.userRepo.updateUser(user);
    }

    @Override
    public boolean removeUser(User user) {
        return this.userRepo.removeUser(user);
    }

    @Override
    public User findUserById(Long id) {
        return this.userRepo.findUserById(id);
    }

    @Override
    public List<User> findAllUserWithDetail() {
        return this.userRepo.findAllUserWithDetail();
    }

    @Override
    public User findUsernameWithDetail(String username) {
        return this.userRepo.findUsernameWithDetail(username);
    }

    @Override
    public List<UserInfo> findUserInfo() {
        return this.userRepo.findUserInfo();
    }

    @Override
    public UserInfo findUserInfoByUsername() {
        return this.userRepo.findUserInfoByUsername();
    }

    @Override
    public int findUserCount() {

        return this.userRepo.findUserCount();
    }
}
