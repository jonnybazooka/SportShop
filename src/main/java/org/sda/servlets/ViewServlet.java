package org.sda.servlets;

import org.sda.models.dao.BasketDao;
import org.sda.models.dao.Impl.BasketDaoImpl;
import org.sda.models.dao.Impl.ProductDaoImpl;
import org.sda.models.dto.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> list = new ProductDaoImpl().getProductList();
        BasketDao basketDao = new BasketDaoImpl();
        if (req.getSession().getAttribute("name") != null) {
            List<Product> basket = basketDao.getAllItems();
            req.setAttribute("basket", basket);
        }
        req.setAttribute("productList",list);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("frontView.jsp");
        requestDispatcher.forward(req,resp);
    }
}
