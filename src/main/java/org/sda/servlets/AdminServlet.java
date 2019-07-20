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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = createNewProductFromRequest(req);
        ProductDao productDao = new ProductDaoImpl();
        productDao.saveProduct(product);
        resp.sendRedirect("adminView.jsp");
    }

    private Product createNewProductFromRequest(HttpServletRequest req) {
        String size = req.getParameter("size");
        String name = req.getParameter("name");
        String colour = req.getParameter("colour");
        String sex = req.getParameter("sex");
        double price = Double.parseDouble(req.getParameter("price"));
        long quantity = Long.parseLong(req.getParameter("quantity"));
        return new Product(size, name, colour, sex, price, quantity, 0);
    }
}
