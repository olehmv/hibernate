package com.shop.model;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "addresses", discriminatorType = DiscriminatorType.STRING)
public abstract class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;
	protected String zipCod;
	protected String city;
	protected String street;
	@ManyToOne
	@JoinColumn(name = "buyerId", insertable = false, updatable = false)
	private Buyer buyer;

	public Address(String city, String street, String zipCod) {
		super();
		this.city = city;
		this.street = street;
		this.zipCod = zipCod;
	}

	public Address() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public String getZipCod() {
		return zipCod;
	}

	public void setZipCod(String zipCod) {
		this.zipCod = zipCod;
	}

	@Override
	public String toString() {
		return "Address [zipCod=" + zipCod + ", city=" + city + ", street=" + street + ", buyer=" + buyer + "]";
	}
}
