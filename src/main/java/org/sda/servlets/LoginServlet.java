package org.sda.servlets;

import org.sda.authentication.HashFunction;
import org.sda.authentication.impl.SHA256;
import org.sda.models.dao.ClientDao;
import org.sda.models.dao.Impl.ClientDaoImpl;
import org.sda.models.dto.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = new SHA256().hashPassword(req.getParameter("password"));

        ClientDao clientDao = new ClientDaoImpl();
        Client client = clientDao.getClientByEmail(email);

        if (client.getPassHash().equals(password)){
            req.getSession().setAttribute("name", client.getName());
            req.getSession().setAttribute("email", client.getEmail());
            Cookie cookie = createSessionCookie(client.getName());
            cookie.setMaxAge(-1);
            resp.addCookie(cookie);
            clientDao.saveCookie(client, cookie);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("frontUserView.jsp");
            requestDispatcher.forward(req,resp);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("loginFault.jsp");
            requestDispatcher.forward(req,resp);
        }

    }

    private Cookie createSessionCookie(String name) {
        HashFunction hashFunction = new SHA256();

        String token = createRandomToken(name);
        Cookie cookie = new Cookie("token", hashFunction.hashPassword(token));
        cookie.setMaxAge(-1);
        return cookie;
    }

    private String createRandomToken(String name) {
        Random random = new Random();
        int randomizer = random.nextInt(100);
        String randomAddon = String.valueOf(randomizer);
        return name + randomAddon;
    }
}
