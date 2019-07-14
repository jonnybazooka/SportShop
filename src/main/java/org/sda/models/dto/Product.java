package org.sda.models.dto;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String size;
    private String colour;
    private String sex;
    private double price;
    private long quantity;
    private long reserved;
    @ManyToOne
    private Basket basket;

    public Product() {
    }

    public Product(String size, String colour, String sex, double price, long quantity, long reserved) {
        this.size = size;
        this.colour = colour;
        this.sex = sex;
        this.price = price;
        this.quantity = quantity;
        this.reserved = reserved;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long qantity) {
        this.quantity = qantity;
    }

    public long getReserved() {
        return reserved;
    }

    public void setReserved(long reserved) {
        this.reserved = reserved;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
