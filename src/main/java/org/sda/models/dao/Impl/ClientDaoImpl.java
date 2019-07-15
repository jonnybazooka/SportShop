package org.sda.models.dao.Impl;

import org.sda.datasource.Datasource;
import org.sda.models.dao.ClientDao;
import org.sda.models.dto.Basket;
import org.sda.models.dto.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.Cookie;

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

    @Override
    public Basket getBasket(Client client) {
        EntityManager entityManager = Datasource.getEntityManager();
        Basket basket = (Basket) entityManager.createQuery("SELECT Basket FROM Client c").getSingleResult();
        if (basket == null) {
            return new Basket();
        }
        return basket;
    }

    @Override
    public void saveCookie(Client client, Cookie cookie) {
        EntityManager entityManager = Datasource.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        client.setCookieValue(cookie.getValue());
        transaction.commit();
    }
}
