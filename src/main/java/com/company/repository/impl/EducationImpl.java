package com.company.repository.impl;

import com.company.model.Education;
import com.company.repository.inter.EducationRepo;
import com.company.factory.Factory;

import javax.persistence.*;
import java.util.List;

public class EducationImpl implements EducationRepo , Factory {

    @Override
    public boolean saveEducation(Education education) {
        try{
            entityTransaction.begin();
            entityManager.persist(education);
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
    public boolean updateEducation(Education education) {
        return false;
    }

    @Override
    public boolean removeEducation(Education education) {
        return false;
    }

    @Override
    public List<Education> findAllEducation() {
        List<Education> educations = null;
        try{
            TypedQuery<Education> typedQuery = entityManager.createNamedQuery("Education.findEducation" , Education.class);
            educations = typedQuery.getResultList();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return educations;
    }

    @Override
    public Education findEducationByIdWithAdvertisement(int id) {
        Education education = null;
        try{
            TypedQuery<Education> typedQuery = entityManager.createNamedQuery("Education.findEducationByIdWithAdvertisement" , Education.class);
            typedQuery.setParameter("id" , id);
            education = typedQuery.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return education;
    }




}
