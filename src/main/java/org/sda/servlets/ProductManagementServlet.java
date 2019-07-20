package org.sda.servlets;

import org.sda.models.dao.Impl.ProductDaoImpl;
import org.sda.models.dao.ProductDao;
import org.sda.models.dto.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductManagementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String add = req.getParameter("add");
        long id = Long.parseLong(req.getParameter("id"));
        ProductDao productDao = new ProductDaoImpl();
        if (add.equals("inc")) {
            Product product = productDao.getProductById(id);
            product.setQuantity(product.getQuantity()+1);
        } else if (add.equals("dec")) {
            Product product = productDao.getProductById(id);
            product.setQuantity(product.getQuantity()-1);
        } else {
            throw new ServletException("Request should be 'dec' or 'inc'");
        }
        resp.sendRedirect("admin");
    }
}
