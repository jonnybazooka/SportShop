package org.sda.servlets;

import org.sda.models.dao.Impl.ProductDaoImpl;
import org.sda.models.dao.ProductDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class dViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductDao> list = new ProductDaoImpl().getProductList();

        req.setAttribute("productList",list);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("frontView.jsp");

        requestDispatcher.forward(req,resp);
    }
}
