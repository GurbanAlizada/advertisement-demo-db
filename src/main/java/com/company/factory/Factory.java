package com.company.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public interface  Factory {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mysql-jpa5");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();


}
