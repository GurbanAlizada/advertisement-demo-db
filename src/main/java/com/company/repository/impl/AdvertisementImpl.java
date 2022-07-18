package com.company.repository.impl;

import com.company.model.Advertisement;
import com.company.repository.inter.AdvertisementRepo;
import com.company.factory.Factory;

import javax.persistence.*;
import java.util.List;

public class AdvertisementImpl  implements AdvertisementRepo ,Factory {


    @Override
    public boolean saveAdvertisement( final Advertisement advertisement) {

        try{
            entityTransaction.begin();
            entityManager.persist(advertisement);
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
    public boolean updateAdvertisement(final Advertisement advertisement) {
        try{
            entityTransaction.begin();
            entityManager.merge(advertisement);
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
    public boolean removeAdvertisement(final Advertisement advertisement) {
        try {
            if (entityManager.contains(advertisement)) {
                entityManager.remove(advertisement);
            } else {
                Advertisement delete = this.findById(advertisement.getAdvertisementId());
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
    public Advertisement findById(final Integer id) {
        Advertisement advertisement = null;
        try{
            TypedQuery<Advertisement> typedQuery = entityManager.createNamedQuery("Advertisement.findById" , Advertisement.class);
            typedQuery.setParameter("id" , id);
             advertisement = typedQuery.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return advertisement;
    }



    @Override
    public List<Advertisement> findAdvertisementByUsername(String username) {

        List<Advertisement> advertisements = null;
        try{
            TypedQuery<Advertisement> typedQuery = entityManager.createNamedQuery("Advertisement.findByUsername" , Advertisement.class);
            typedQuery.setParameter("username" , username);
            advertisements = typedQuery.getResultList();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return advertisements;
    }



    @Override
    public List<Advertisement> findAllAdvertisements() {
        List<Advertisement> advertisements = null;
        try{
            TypedQuery<Advertisement> typedQuery = entityManager.createNamedQuery("Advertisement.findAll" , Advertisement.class);
            advertisements = typedQuery.getResultList();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return advertisements;
    }






}
