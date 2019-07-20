package org.sda.models.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private long id;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SoldProduct> products = new ArrayList<>();
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

    public List<SoldProduct> getProducts() {
        return products;
    }

    public void setProducts(List<SoldProduct> products) {
        this.products = products;
    }

    public void addProduct(SoldProduct product) {
        this.products.add(product);
        product.addTransaction(this);
    }

    public void removeProduct(SoldProduct product) {
        this.products.remove(product);
        product.removeTransaction(this);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


}
