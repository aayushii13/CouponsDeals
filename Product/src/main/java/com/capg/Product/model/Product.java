 package com.capg.Product.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection="product")
public class Product {

	@Id
	private String prodName;
	private String prodPrice;
	private String coupon;
	private String image;
	private String cashBack;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String prodName, String prodPrice, String coupon, String image, String cashBack) {
		super();
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.coupon = coupon;
		this.image = image;
		this.cashBack = cashBack;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(String prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getCoupon() {
		return coupon;
	}
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCashBack() {
		return cashBack;
	}
	public void setCashBack(String cashBack) {
		this.cashBack = cashBack;
	}
	
	
}
