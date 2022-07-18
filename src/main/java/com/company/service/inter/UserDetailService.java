package com.company.service.inter;

import com.company.model.UserDetail;

public interface UserDetailService {

    boolean saveUserDetail(UserDetail userDetail);

    boolean updateUserDetail(UserDetail userDetail);

    boolean removeUserDetail(UserDetail userDetail);

    UserDetail findByUserName(String username);

    UserDetail findAddressByUsername(String username);

    UserDetail findAdvertisementByUserName(String username);


}
