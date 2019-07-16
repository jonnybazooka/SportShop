package org.sda.authentication;

import javax.servlet.http.Cookie;

public interface IdentityAuthenticator {
    /**
     * Checks the token value of a session cookie against the token value assigned
     * to the client, to assert that the client successfully logged-in during
     * current session.
     * @param email Unique email of the client. Should be retrieved from session context.
     * @param cookies Cookies Array should be retrieved from request.
     * @return <tt>true</tt> if token values match.
     *         <tt>false</tt> if token values don't match.
     */
    boolean authenticateCookieValue(String email, Cookie[] cookies);
}
