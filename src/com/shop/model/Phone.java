package com.shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Phone {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long phoneId; 
	private String brand;
	private String model;
	private Double price;
	@ManyToOne
	@JoinColumn(name="buyerId", 
				insertable=false, updatable=false)
	private Buyer buyer;
	public Phone() {
		super();
	}

	public Phone(String brand, String model, Double price) {
		super();
		this.brand = brand;
		this.model = model;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
