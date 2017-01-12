package com.shop.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class HomeAddress extends Address {
	public HomeAddress(String city, String street, String zipCod) {
		super(city, street, zipCod);
	}
	public HomeAddress() {
		super();
	}

}
