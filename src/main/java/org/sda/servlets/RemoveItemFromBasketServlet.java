package org.sda.servlets;

import org.sda.models.dao.ClientDao;
import org.sda.models.dao.Impl.ClientDaoImpl;
import org.sda.models.dao.Impl.ProductDaoImpl;
import org.sda.models.dao.ProductDao;
import org.sda.models.dto.Basket;
import org.sda.models.dto.Client;
import org.sda.models.dto.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveItemFromBasketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("itemId"));
        ClientDao clientDao = new ClientDaoImpl();
        Client client = clientDao.getClientByEmail((String) req.getSession().getAttribute("email"));
        Basket basket = clientDao.getBasket(client);
        ProductDao productDao = new ProductDaoImpl();
        Product product = productDao.getProductById(id);
        productDao.removeFromBasket(product, basket);

        resp.sendRedirect("basket");
    }
}
