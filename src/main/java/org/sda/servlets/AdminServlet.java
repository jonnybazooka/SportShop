package org.sda.servlets;

import org.sda.models.dao.Impl.ProductDaoImpl;
import org.sda.models.dao.ProductDao;
import org.sda.models.dto.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao productDao = new ProductDaoImpl();
        List<Product> products = productDao.getProductList();
        req.setAttribute("products", products);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("adminView.jsp");
        requestDispatcher.forward(req, resp);
    }
}
