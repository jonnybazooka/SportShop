package org.sda.models.dao.Impl;

import org.sda.datasource.Datasource;
import org.sda.models.dao.ClientDao;
import org.sda.models.dto.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ClientDaoImpl implements ClientDao {
    @Override
    public void saveClient(Client client) {
        EntityManager entityManager = Datasource.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(client);
        transaction.commit();
    }

    @Override
    public Client getClientByEmail(String email) {
        EntityManager entityManager = Datasource.getEntityManager();
        Client client = (Client) entityManager.createQuery("SELECT c FROM Client c WHERE c.email = :email")
                .setParameter("email", email)
                .getSingleResult();
        return client;
    }
}
