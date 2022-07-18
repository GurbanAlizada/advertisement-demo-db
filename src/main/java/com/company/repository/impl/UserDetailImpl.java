package com.company.repository.impl;

import com.company.model.UserDetail;
import com.company.factory.Factory;
import com.company.repository.inter.UserDetailRepo;

import javax.persistence.*;

public class UserDetailImpl implements UserDetailRepo , Factory {


    @Override
    public boolean saveUserDetail(UserDetail userDetail) {
        try{
            entityTransaction.begin();
            entityManager.persist(userDetail);
            entityTransaction.commit();
        } catch (Exception e) {
            System.out.println("Error : " +e);
            try {
                entityTransaction.rollback();
            } catch (Exception exception) {
                System.out.println("Error : " + exception);

            }
            return false;
        }

        return true;
    }

    @Override
    public boolean updateUserDetail(UserDetail userDetail) {
        return false;
    }

    @Override
    public boolean removeUserDetail(UserDetail userDetail) {
        return false;
    }

    @Override
    public UserDetail findByUserName(String username) {
        UserDetail userDetail = null;
        try{
            TypedQuery<UserDetail> typedQuery = entityManager.createNamedQuery("UserDetail.findByUserName" , UserDetail.class);
            typedQuery.setParameter("username" , username);
            userDetail = typedQuery.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return userDetail;
    }


    @Override
    public UserDetail findAddressByUsername(String username) {
        UserDetail userDetail = null;
        try{
            TypedQuery<UserDetail> typedQuery = entityManager.createNamedQuery("UserDetail.findAddressByUsername" , UserDetail.class);
            typedQuery.setParameter("username" , username);
            userDetail = typedQuery.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return userDetail;
    }

    @Override
    public UserDetail findAdvertisementByUserName(String username) {
        UserDetail userDetail = null;
        try{
            TypedQuery<UserDetail> typedQuery = entityManager.createNamedQuery("User.Detail.findAdvertisementByUserName" , UserDetail.class);
            typedQuery.setParameter("username" , username);
            userDetail = typedQuery.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return userDetail;
    }



}
