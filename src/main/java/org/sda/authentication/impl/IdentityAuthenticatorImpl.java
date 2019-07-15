package org.sda.authentication.impl;

import org.sda.authentication.IdentityAuthenticator;
import org.sda.models.dao.ClientDao;
import org.sda.models.dao.Impl.ClientDaoImpl;
import org.sda.models.dto.Client;

import javax.servlet.http.Cookie;

public class IdentityAuthenticatorImpl implements IdentityAuthenticator {
    @Override
    public boolean authenticateCookieValue(String email, Cookie[] cookies) {
        ClientDao clientDao = new ClientDaoImpl();
        Client client = clientDao.getClientByEmail(email);
        String cookieValue = client.getCookieValue();

        for (Cookie cookie : cookies) {
            if (cookie.getValue().equalsIgnoreCase(cookieValue)) {
                return true;
            }
        }
        return false;
    }
}
