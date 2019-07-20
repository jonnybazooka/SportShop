package org.sda.models.dao.Impl;

import org.sda.datasource.Datasource;
import org.sda.models.dao.BasketDao;
import org.sda.models.dto.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BasketDaoImpl implements BasketDao {

    @Override
    public void sellAllItems(Client client, Basket basket) {
        EntityManager entityManager = Datasource.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Transaction transaction = new Transaction();

        entityTransaction.begin();
        List<Product> products = basket.getProducts();
        for (Product product : products) {
            SoldProduct soldProduct = new SoldProduct();
            soldProduct.setName(product.getName());
            soldProduct.setColour(product.getColour());
            soldProduct.setSex(product.getSex());
            soldProduct.setSize(product.getSize());
            soldProduct.setPrice(product.getPrice());
            soldProduct.setQuantity(product.getReserved());
            transaction.addProduct(soldProduct);
        }
        client.addTransaction(transaction);

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
