package org.sda.models.dao;

import org.sda.models.dto.Basket;
import org.sda.models.dto.Client;

import javax.servlet.http.Cookie;

public interface ClientDao {
    void saveClient(Client client);
    Client getClientByEmail(String email);
    Basket getBasket(Client client);
    void saveCookie(Client client, Cookie cookie);
}
