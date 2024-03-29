package com.capg.Product.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection="deals")
public class Deals {

	@Id
	private String prodName;
	private String prodPrice;
	private String image;
	public Deals(String prodName, String prodPrice, String image) {
		super();
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.image = image;
	}
	public Deals() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	

}
