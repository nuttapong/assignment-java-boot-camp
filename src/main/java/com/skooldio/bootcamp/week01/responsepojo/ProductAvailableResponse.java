package com.skooldio.bootcamp.week01.responsepojo;

import com.skooldio.bootcamp.week01.entity.Product;

public class ProductAvailableResponse {

    private int id;
    private String size;
    private int qty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
