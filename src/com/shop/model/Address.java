package com.shop.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "addresses", discriminatorType = DiscriminatorType.STRING)
public abstract class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "addressPk")
	protected int address;
	protected String zipCod;
	protected String city;
	protected String street;

	public Address(String zipCod, String city, String street) {
		super();
		this.city = city;
		this.street = street;
		this.zipCod = zipCod;
	}

	public Address() {
		super();
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

	public String getZipCod() {
		return zipCod;
	}

	public void setZipCod(String zipCod) {
		this.zipCod = zipCod;
	}
}
