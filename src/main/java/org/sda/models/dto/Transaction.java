package org.sda.models.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private long id;
    @OneToMany
    private List<Product> products = new ArrayList<>();
    @ManyToOne
    private Client client;

    public Transaction() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
        product.setTransaction(this);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
        product.setTransaction(null);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


}
