package org.sda.models.dao;

import org.sda.models.dto.Client;
import org.sda.models.dto.Product;

import java.util.List;

public interface BasketDao {
    /**
     * Returns a complete list of all products that are currently in a basket.
     *
     * @return <tt>null</tt> if the basket is currently empty.
     */
    List<Product> getAllItems();

    /**
     * This method creates a new transaction and put's all items from a basket
     * to the the transaction. Implementation of this method should decrease
     * the 'quantity' field of a product object by the amount bought and
     * 'reserved' field should be set to 0.
     *
     * @param client Current client, should be retrieved from database.
     */
    void sellAllItems(Client client);
}
