package org.sda.servlets;

import org.sda.models.dao.Impl.ProductDaoImpl;
import org.sda.models.dao.ProductDao;
import org.sda.models.dto.Basket;
import org.sda.models.dto.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddToBasketServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));

        ProductDao productDao = new ProductDaoImpl();
        List<Product> list = productDao.getProductList();

        Product product = null;
        for (Product p: list){
            if (p.getId() == id) {
                product = p;
                break;
            }
        }

        productDao.putInBasket(product,new Basket());


     }
}
