package com.skooldio.bootcamp.week01.responsepojo;

public class ShoppingCartDetailResponse {

    private int productInCartId;
    private String description;
    private String color;
    private String size;
    private int price;
    private int discountPercent;
    private int discountPrice;
    private int priceIncludeVat;
    private String thumbnailImage;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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

    public int getPriceIncludeVat() {
        return priceIncludeVat;
    }

    public void setPriceIncludeVat(int priceIncludeVat) {
        this.priceIncludeVat = priceIncludeVat;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    public int getProductInCartId() {
        return productInCartId;
    }

    public void setProductInCartId(int productInCartId) {
        this.productInCartId = productInCartId;
    }
}
