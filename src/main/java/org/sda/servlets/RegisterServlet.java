package org.sda.servlets;

import org.sda.authentication.impl.SHA256;
import org.sda.models.dao.ClientDao;
import org.sda.models.dao.Impl.ClientDaoImpl;
import org.sda.models.dto.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String password = new SHA256().hashPassword(req.getParameter("passHash"));

        ClientDao clientDao = new ClientDaoImpl();
        clientDao.saveClient(new Client(email, name, password));

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("sign_In.jsp");
        requestDispatcher.forward(req, resp);
    }
}
