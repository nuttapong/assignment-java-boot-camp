package com.skooldio.bootcamp.week01.entity;

import javax.persistence.*;

@Entity
@Table(name = "product_available")
public class ProductAvailable {

	@Id
	private int id;
	private String size;
	private int qty;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	public ProductAvailable(){}

	public ProductAvailable(int id, String size, int qty, Product product){
		this.id = id;
		this.size = size;
		this.qty = qty;
		this.product = product;
	}

	public void setSize(String size){
		this.size = size;
	}

	public String getSize(){
		return size;
	}

	public void setQty(int qty){
		this.qty = qty;
	}

	public int getQty(){
		return qty;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
