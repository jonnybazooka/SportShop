package org.sda.datasource;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Datasource {

    private static EntityManagerFactory entityManagerFactory = javax.persistence.Persistence.createEntityManagerFactory("roadRageMySQL");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    private Datasource() {}

    public static EntityManager getEntityManager() {
        return entityManager;
    }
}
