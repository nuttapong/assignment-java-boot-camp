package com.skooldio.bootcamp.week01.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product{

	@Id
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

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private List<ProductAvailable> productAvailable;

	public Product(){}

	public Product(int id){
		this.id = id;
	}

	public void setColor(String color){
		this.color = color;
	}

	public String getColor(){
		return color;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice(){
		return price;
	}

	public void setDiscountPrice(int discountPrice){
		this.discountPrice = discountPrice;
	}

	public int getDiscountPrice(){
		return discountPrice;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setProductCode(String productCode){
		this.productCode = productCode;
	}

	public String getProductCode(){
		return productCode;
	}

	public void setDiscountPercent(int discountPercent){
		this.discountPercent = discountPercent;
	}

	public int getDiscountPercent(){
		return discountPercent;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getProductName(){
		return productName;
	}

	public void setBrand(String brand){
		this.brand = brand;
	}

	public String getBrand(){
		return brand;
	}

	public void setThumbnailImage(String thumbnailImage){
		this.thumbnailImage = thumbnailImage;
	}

	public String getThumbnailImage(){
		return thumbnailImage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<ProductAvailable> getProductAvailable() {
		return productAvailable;
	}

	public void setProductAvailable(List<ProductAvailable> productAvailable) {
		this.productAvailable = productAvailable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}