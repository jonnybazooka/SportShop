package org.sda.models.dao.Impl;

import org.sda.datasource.Datasource;
import org.sda.models.dao.ProductDao;
import org.sda.models.dto.Basket;
import org.sda.models.dto.Product;
import org.sda.models.factory.ProductFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public List<Product> getProductList() {
        EntityManager entityManager = Datasource.getEntityManager();
        List<Product> products = entityManager.createQuery("FROM Product p").getResultList();
        return products;
    }

    // temporary for development purposes only
    /*@Override
    public List<Product> getProductList() {
        return ProductFactory.createProductList();
    }*/

    @Override
    public void saveProduct(Product product) {
        EntityManager entityManager = Datasource.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(product);
        transaction.commit();
    }

    @Override
    public void putInBasket(Product product, Basket basket) {
        EntityManager entityManager = Datasource.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        product.setReserved(product.getReserved()+1);
        basket.addProduct(product);
        transaction.commit();
    }

    @Override
    public Product getProductById(long id) {
        EntityManager entityManager = Datasource.getEntityManager();
        return entityManager.find(Product.class, id);
    }
}
