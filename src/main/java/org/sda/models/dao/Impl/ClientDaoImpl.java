package org.sda.models.dao.Impl;

import org.sda.datasource.Datasource;
import org.sda.models.dao.ClientDao;
import org.sda.models.dto.Basket;
import org.sda.models.dto.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import java.util.List;

public class ClientDaoImpl implements ClientDao {
    @Override
    public void saveClient(Client client) throws ServletException {
        EntityManager entityManager = Datasource.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(client);
            transaction.commit();
        } catch (RollbackException e) {
            throw new ServletException("Client with email: " + client.getEmail() + " already exists in database.");
        }
    }

    @Override
    public Client getClientByEmail(String email) {
        EntityManager entityManager = Datasource.getEntityManager();
        List<Client> result = (List<Client>) entityManager.createQuery("SELECT c FROM Client c WHERE c.email = :email")
                .setParameter("email", email)
                .getResultList();
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    @Override
    public Basket getBasket(Client client) {
        EntityManager entityManager = Datasource.getEntityManager();
        List<Basket> result = (List<Basket>) entityManager.createQuery("SELECT c.basket FROM Client c").getResultList();
        if (result.isEmpty()) {
            Basket basket = new Basket();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            client.setBasket(basket);
            entityManager.persist(client);
            transaction.commit();
            return basket;
        }
        return result.get(0);
    }

    @Override
    public void saveCookie(Client client, Cookie cookie) {
        EntityManager entityManager = Datasource.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        client.setCookieValue(cookie.getValue());
        entityManager.persist(client);
        transaction.commit();
    }
}
