package org.sda.models.dao;

import org.sda.models.dto.Client;

public interface BasketDao {
    void createNewBasket(Client client);
    void sellAllItems(Client client);
}
