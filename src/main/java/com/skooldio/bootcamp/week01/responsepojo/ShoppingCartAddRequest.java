package com.skooldio.bootcamp.week01.responsepojo;

public class ShoppingCartAddRequest {

    private int productAvailableId;
    private int quantity;
    private String username;

    public int getProductAvailableId() {
        return productAvailableId;
    }

    public void setProductAvailableId(int productAvailableId) {
        this.productAvailableId = productAvailableId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
