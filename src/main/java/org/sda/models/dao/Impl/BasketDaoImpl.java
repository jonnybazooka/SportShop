package org.sda.models.dao.Impl;

import org.sda.datasource.Datasource;
import org.sda.models.dao.BasketDao;
import org.sda.models.dto.Basket;
import org.sda.models.dto.Client;
import org.sda.models.dto.Product;
import org.sda.models.dto.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BasketDaoImpl implements BasketDao {

    @Override
    public void sellAllItems(Client client) {
        EntityManager entityManager = Datasource.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Basket basket = entityManager.find(Basket.class, client.getId());
        Transaction transaction = new Transaction();
        transaction.setProducts(basket.getProducts());
        transaction.setClient(client);

        entityTransaction.begin();
        for (Product product : basket.getProducts()) {
            product.setQuantity(product.getQuantity() - product.getReserved());
            product.setReserved(0L);
        }
        entityManager.persist(transaction);
        entityManager.remove(basket);
        entityTransaction.commit();
    }

    @Override
    public List<Product> getAllItems() {
        EntityManager entityManager = Datasource.getEntityManager();
        List<Product> allItems = entityManager.createQuery("SELECT b.products FROM Basket b").getResultList();
        return allItems;
    }
}
