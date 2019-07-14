package org.sda.servlets;

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

public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = new SHA256().hashPassword(req.getParameter("password"));

        ClientDao clientDao = new ClientDaoImpl();
        Client client = clientDao.getClientByEmail(email);

        if (client.getPassHash().equals(password)){
            Cookie cookie = new Cookie("user", "valid");
            cookie.setMaxAge(-1);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("frontUserView.jsp");
            requestDispatcher.forward(req,resp);
        }else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("loginFault.jsp");
            requestDispatcher.forward(req,resp);
        }

    }
}
