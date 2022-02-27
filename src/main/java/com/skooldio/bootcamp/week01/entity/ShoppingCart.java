package com.skooldio.bootcamp.week01.entity;

import javax.persistence.*;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_available_id", nullable = false)
    private ProductAvailable productAvailable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public ShoppingCart(){}

    public ShoppingCart(int id, int quantity, ProductAvailable productAvailable, User user){
        this.id = id;
        this.quantity = quantity;
        this.productAvailable = productAvailable;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductAvailable getProductAvailable() {
        return productAvailable;
    }

    public void setProductAvailable(ProductAvailable productAvailable) {
        this.productAvailable = productAvailable;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
