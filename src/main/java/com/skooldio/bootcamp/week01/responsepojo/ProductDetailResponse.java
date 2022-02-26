package com.skooldio.bootcamp.week01.responsepojo;

import java.util.List;

public class ProductDetailResponse {

    private int id;
    private String brand;
    private String title;
    private String productName;
    private String productCode;
    private String color;
    private String description;
    private int price;
    private int discountPercent;
    private int discountPrice;
    private String thumbnailImage;
    private List<ProductAvailableResponse> productAvailableResponseList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    public List<ProductAvailableResponse> getProductAvailableResponseList() {
        return productAvailableResponseList;
    }

    public void setProductAvailableResponseList(List<ProductAvailableResponse> productAvailableResponseList) {
        this.productAvailableResponseList = productAvailableResponseList;
    }
}
