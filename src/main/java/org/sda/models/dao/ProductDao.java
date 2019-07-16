package org.sda.models.dao;

import org.sda.models.dto.Basket;
import org.sda.models.dto.Product;

import java.util.List;

public interface ProductDao {
    /**
     * Returns a complete list of all products from database.
     *
     * @return <tt>null</tt> if there are no products in database.
     */
    List<Product> getProductList();

    /**
     * Writes a new Product object into database.
     *
     * @param product Product should be fully created beforehand.
     */
    void saveProduct(Product product);

    /**
     * This method puts a product into a client's basket. Implementation of this
     * method should increase 'reserved' field of 'product' object.
     *
     * @param product Product should be retrieved from the database.
     * @param basket  Basket should be retrieved from the 'client' object.
     */
    void putInBasket(Product product, Basket basket);
}
