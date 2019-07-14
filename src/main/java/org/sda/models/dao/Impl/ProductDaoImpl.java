package org.sda.models.dao.Impl;

import org.sda.datasource.Datasource;
import org.sda.models.dao.ProductDao;
import org.sda.models.dto.Product;

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

    @Override
    public void saveProduct(Product product) {
        EntityManager entityManager = Datasource.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(product);
        transaction.commit();
    }
}
