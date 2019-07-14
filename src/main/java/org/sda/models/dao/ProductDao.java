package org.sda.models.dao;

import org.sda.models.dto.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProductList();
}
