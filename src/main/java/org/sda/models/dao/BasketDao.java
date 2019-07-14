package org.sda.models.dao;

import org.sda.models.dto.Client;
import org.sda.models.dto.Product;

import java.util.List;

public interface BasketDao {
    void createNewBasket(Client client);
    List<Product> getAllItems();
    void sellAllItems(Client client);
}
