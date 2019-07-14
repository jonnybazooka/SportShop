package org.sda.models.dao.Impl;

import org.sda.datasource.Datasource;
import org.sda.models.dao.ProductDao;
import org.sda.models.dto.Product;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public List<Product> getProductList() {
        EntityManager entityManager = Datasource.getEntityManager();
        List<Product> products = entityManager.createQuery("FROM Product p").getResultList();
        return products;
    }
}
