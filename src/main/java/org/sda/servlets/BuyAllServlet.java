package org.sda.servlets;

import org.sda.models.dao.BasketDao;
import org.sda.models.dao.ClientDao;
import org.sda.models.dao.Impl.BasketDaoImpl;
import org.sda.models.dao.Impl.ClientDaoImpl;
import org.sda.models.dto.Basket;
import org.sda.models.dto.Client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BuyAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BasketDao basketDao = new BasketDaoImpl();
        ClientDao clientDao = new ClientDaoImpl();
        Client client = clientDao.getClientByEmail((String) req.getSession().getAttribute("email"));
        Basket basket = clientDao.getBasket(client);
        basketDao.sellAllItems(client, basket);

        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath);
    }
}
