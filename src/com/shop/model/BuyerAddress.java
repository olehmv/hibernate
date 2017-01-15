package com.shop.model;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class BuyerAddress extends Address {
	public BuyerAddress(String zipCod, String city, String street) {
		super(zipCod, city, street);
	}

	public BuyerAddress() {
		super();
	}

}
