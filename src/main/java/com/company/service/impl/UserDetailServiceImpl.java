package com.company.service.impl;

import com.company.model.UserDetail;
import com.company.repository.impl.UserDetailImpl;
import com.company.repository.inter.UserDetailRepo;
import com.company.service.inter.UserDetailService;

public class UserDetailServiceImpl implements UserDetailService {

    private UserDetailRepo userDetailRepo = new UserDetailImpl();

    @Override
    public boolean saveUserDetail(UserDetail userDetail) {
        return this.userDetailRepo.saveUserDetail(userDetail);
    }

    @Override
    public boolean updateUserDetail(UserDetail userDetail) {
        return this.userDetailRepo.updateUserDetail(userDetail);
    }

    @Override
    public boolean removeUserDetail(UserDetail userDetail) {
        return this.userDetailRepo.removeUserDetail(userDetail);
    }

    @Override
    public UserDetail findByUserName(String username) {
        return this.userDetailRepo.findByUserName(username);
    }

    @Override
    public UserDetail findAddressByUsername(String username) {
        return this.userDetailRepo.findAddressByUsername(username);
    }

    @Override
    public UserDetail findAdvertisementByUserName(String username) {
        return this.userDetailRepo.findAdvertisementByUserName(username);
    }
}
