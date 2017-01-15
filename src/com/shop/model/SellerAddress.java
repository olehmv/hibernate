package com.shop.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
public class SellerAddress extends Address {
	public SellerAddress( String zipCod, String city, String street) {
		super(zipCod, city, street);
	}
	public SellerAddress() {
		super();
	}
}
