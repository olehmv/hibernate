package com.shop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.IndexColumn;

@Entity
public class Phone implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//private int phoneId; 
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name="sellerId")
	private Seller seller;
	private String brand;
	private String model;
	private Double price;
	@ManyToMany(cascade = CascadeType.DETACH,mappedBy="basketPhones")
	private Set<Basket> baskets=new HashSet<>();
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

//	public int getPhoneId() {
//		return phoneId;
//	}
//
//	public void setPhoneId(int phoneId) {
//		this.phoneId = phoneId;
//	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Set<Basket> getBaskets() {
		return baskets;
	}

	public void setBaskets(Set<Basket> baskets) {
		this.baskets = baskets;
	}

	
	
	
}
