package com.shop.model;

import java.sql.Blob;
import java.sql.Clob;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Phone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int phoneId;
	private String brand;
	private String model;
	private Double price;
	private Clob desciption;
	private Blob image;
	private String status;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sellerId")
	private Seller seller;

	public Phone() {
		super();
	}

	public Phone(String brand, String model, Double price) {
		super();
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.status = Status.AVAILABLE.getValue();
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

	public int getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}

	public Clob getDesciption() {
		return desciption;
	}

	public void setDesciption(Clob desciption) {
		this.desciption = desciption;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Status getStatus() {
		return Status.parse(this.status);
	}

	public void setStatus(Status status) {
		this.status = status.getValue();
	}

	@Override
	public String toString() {
		return "Phone [phoneId=" + phoneId + ", brand=" + brand + ", model=" + model + ", price=" + price
				+ ", desciption=" + desciption + ", image=" + image + ", status=" + status + ", seller=" + seller + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + phoneId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		if (phoneId != other.phoneId)
			return false;
		return true;
	}
	

}
