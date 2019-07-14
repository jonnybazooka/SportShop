package org.sda.models.dao;

import org.sda.models.dto.Basket;
import org.sda.models.dto.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProductList();
    void saveProduct(Product product);
    void putInBasket(Product product, Basket basket);
}
