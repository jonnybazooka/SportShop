package org.sda.authentication;

import javax.servlet.http.Cookie;

public interface IdentityAuthenticator {
    boolean authenticateCookieValue(String email, Cookie[] cookies);
}
