package org.sda.models.factory;

import org.sda.models.dto.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductFactory {
    public static List<Product> createProductList() {
        Product product1 = new Product("XXL", "Nike Running Boots", "Blue", "M", 249.99, 10, 0);
        Product product2 = new Product("S", "Sport Bra", "Black/Red", "F", 49.99, 15, 0);
        Product product3 = new Product("M", "Nike T-Shirt", "White", "M", 59.50, 22, 0);
        Product product4 = new Product("XL", "Adidas Leggins", "White/Black", "F", 84.99, 7, 0);
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        return products;
    }
}
