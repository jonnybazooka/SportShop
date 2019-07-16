package org.sda.authentication.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.sda.authentication.IdentityAuthenticator;
import org.sda.models.dao.ClientDao;
import org.sda.models.dto.Client;

import javax.servlet.http.Cookie;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IdentityAuthenticatorImplTests {
    @Mock
    private ClientDao clientDao;
    @InjectMocks
    private IdentityAuthenticator identityAuthenticator = new IdentityAuthenticatorImpl();
    private Client client;
    private String email;
    private Cookie[] cookies;
    private boolean expected;

    @Before
    public void initialize() {
        client = new Client();
        client.setEmail(email);
        client.setCookieValue("A441B15FE9A3CF56661190A0B93B9DEC7D04127288CC87250967CF3B52894D11".toLowerCase());
        MockitoAnnotations.initMocks(this);
    }

    public IdentityAuthenticatorImplTests(String email, Cookie[] cookies, boolean expected) {
        this.email = email;
        this.cookies = cookies;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection emailsAndCookies() {
        return Arrays.asList(new Object[][] {
                {"tgieraltowski@gmail.com"
                        , new Cookie[]{new Cookie("token", "A441B15FE9A3CF56661190A0B93B9DEC7D04127288CC87250967CF3B52894D11".toLowerCase())}
                        , true},
                {"robert.kubica@gmail.com"
                        , new Cookie[]{new Cookie("token", "48D98320933CDFA5B3ABA17DC868EE45CDFBA29A5B004F9C1DCCC97159E8403E".toLowerCase())}
                        , false}
        });
    }

    @Test
    public void testAuthenticateCookieValue() {
        Mockito.when(clientDao.getClientByEmail(email)).thenReturn(client);
        boolean isAuthenticated = identityAuthenticator.authenticateCookieValue(email, cookies);
        assertEquals(expected, isAuthenticated);
    }
}
