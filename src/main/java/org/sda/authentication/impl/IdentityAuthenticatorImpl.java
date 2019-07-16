package org.sda.authentication.impl;

import org.sda.authentication.IdentityAuthenticator;
import org.sda.models.dao.ClientDao;
import org.sda.models.dao.Impl.ClientDaoImpl;
import org.sda.models.dto.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;

public class IdentityAuthenticatorImpl implements IdentityAuthenticator {
    private static Logger logger = LoggerFactory.getLogger(IdentityAuthenticator.class);

    @Override
    public boolean authenticateCookieValue(String email, Cookie[] cookies) {
        ClientDao clientDao = new ClientDaoImpl();
        Client client = clientDao.getClientByEmail(email);
        String cookieValue = client.getCookieValue();

        for (Cookie cookie : cookies) {
            if (cookie.getValue().equalsIgnoreCase(cookieValue)) {
                logger.info("User: " + client.getEmail() + " authenticated correctly.");
                return true;
            }
        }
        logger.info("User: " + client.getEmail() + " authentication failed.");
        return false;
    }
}
