package com.company.repository.impl;

import com.company.model.User;
import com.company.model.UserInfo;
import com.company.factory.Factory;
import com.company.repository.inter.UserRepo;

import javax.persistence.*;
import java.util.List;

public class UserImpl implements UserRepo , Factory {

    @Override
    public boolean saveUser(final User user) {
        try{
            entityTransaction.begin();
            entityManager.persist(user);
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
    public boolean updateUser(final User user) {
        try{
            entityTransaction.begin();
            entityManager.merge(user);
            entityManager.flush();
            entityTransaction.commit();
        } catch (Exception e) {
            System.out.println("Error : "  + e);
            try{
                entityTransaction.rollback();
            } catch (Exception exception) {
                System.out.println("Error : " + exception);
            }

            return  false;
        }
        return true;
    }



    @Override
    public boolean removeUser(final User user) {
        try {
            if (entityManager.contains(user)) {
                entityManager.remove(user);
            } else {
                User delete = this.findUserById(user.getUserId());
                entityManager.remove(delete);
            }
        } catch (Exception e) {
            System.out.println("Error  :  " + e);
            try {
                entityTransaction.rollback();
            } catch (Exception exception) {
                System.out.println("Error : " + e);
            }
            return false;
        }
        return true;
    }

    @Override
    public User findUserById(final Long id) {
        User user = null;
        try{
            TypedQuery<User> typedQuery = entityManager.createNamedQuery("User.findUserById" , User.class);
            typedQuery.setParameter("id" , id);
            user = typedQuery.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return user;
    }


    @Override
    public List<User> findAllUserWithDetail() {
        List<User> users = null;
        try{
            TypedQuery<User> typedQuery = entityManager.createNamedQuery("User.findAllUserWithDetail" , User.class);
            users = typedQuery.getResultList();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return users;
    }


    @Override
    public User findUsernameWithDetail(final String username) {
        User user = null;
        try{
            TypedQuery<User> typedQuery = entityManager.createNamedQuery("User.findUsernameWithDetail" , User.class);
            typedQuery.setParameter("username" , username);
            user = typedQuery.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return user;
    }

    @Override
    public List<UserInfo> findUserInfo() {
        List<UserInfo> userInfos = null;
        try{
            TypedQuery<UserInfo> typedQuery = entityManager.createNamedQuery("User.findUserInfo" , UserInfo.class);
            userInfos = typedQuery.getResultList();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }

        return userInfos;
    }

    @Override
    public UserInfo findUserInfoByUsername() {
        UserInfo userInfo = null;
        try{
            TypedQuery<UserInfo> typedQuery = entityManager.createNamedQuery("User.findUserInfoByUsername" , UserInfo.class);
            userInfo = typedQuery.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return userInfo;
    }

    @Override
    public long findUserCount() {
        int count=0;
        try {
            TypedQuery<Integer> typedQuery = entityManager.createNamedQuery("User.findUserCount", Integer.class);
             count = typedQuery.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return count;
    }



}
