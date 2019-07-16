package org.sda.models.dao;

import org.sda.models.dto.Basket;
import org.sda.models.dto.Client;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;

public interface ClientDao {
    /**
     * Writes a new client into a database.
     * @param client New client object that will be persisted.
     * @throws ServletException when client with passed email already exists in database.
     */
    void saveClient(Client client) throws ServletException;

    /**
     * Returns a client object from a database.
     * @param email Email of a client that will be returned. Emails are unique in database.
     * @return <tt>null</tt> if email doesn't match any record in database.
     */
    Client getClientByEmail(String email);

    /**
     * Returns a Basket object from a database. Baskets are unique for each client and a client can have only one basket.
     * @param client Client object who's basket will be returned.
     * @return Creates a new basket to return, if the basket doesn't exist.
     */
    Basket getBasket(Client client);

    /**
     * Writes a new cookie into database. Cookie will be used to authenticate the client during session. If the cookie
     * already exists, it will be overwritten by a new one, and that will lead to authentication methods to fail, so
     * this method should be used only once per client per session.
     * @param client Existing client for whom the cookie will be written.
     * @param cookie Cookie that will be written. It should be fully created beforehand.
     */
    void saveCookie(Client client, Cookie cookie);
}
