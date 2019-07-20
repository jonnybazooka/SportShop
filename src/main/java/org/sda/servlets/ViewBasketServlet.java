package org.sda.servlets;

import org.sda.models.dao.BasketDao;
import org.sda.models.dao.Impl.BasketDaoImpl;
import org.sda.models.dto.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ViewBasketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BasketDao basketDao = new BasketDaoImpl();
        List<Product> products = basketDao.getAllItems();
        req.setAttribute("products", products);
        RequestDispatcher dispatcher = req.getRequestDispatcher("basket.jsp");
        dispatcher.forward(req, resp);
    }
}
