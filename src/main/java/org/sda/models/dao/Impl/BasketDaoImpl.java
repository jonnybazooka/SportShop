package org.sda.models.dao.Impl;

import org.sda.datasource.Datasource;
import org.sda.models.dao.BasketDao;
import org.sda.models.dto.Basket;
import org.sda.models.dto.Client;
import org.sda.models.dto.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class BasketDaoImpl implements BasketDao {
    @Override
    public void createNewBasket(Client client) {
        EntityManager entityManager = Datasource.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Basket basket = new Basket();

        transaction.begin();
        client.setBasket(basket);
        transaction.commit();
    }

    @Override
    public void sellAllItems(Client client) {
        EntityManager entityManager = Datasource.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Basket basket = entityManager.find(Basket.class, client.getId());
        Transaction transaction = new Transaction();
    }
}
