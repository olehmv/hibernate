package com.shop.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.IndexColumn;

@Entity
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sellerId;
	private String name;
	private String phoneNumber;
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "sellerFk")
	private Address sellerAddress;

//	@ElementCollection
//    @JoinColumn(name = "sellerFK")
	@SuppressWarnings("deprecation")
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name="basketId")
	@IndexColumn(name = "idx")
	private Collection<Phone> sellerPhones = new ArrayList<>();

	public Seller(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getSellerAddress() {
		return sellerAddress;
	}

	public void setSellerAddress(Address sellerAddress) {
		this.sellerAddress = sellerAddress;
	}

	public Collection<Phone> getSellerPhones() {
		return sellerPhones;
	}

	public void setSellerPhones(Collection<Phone> sellerPhones) {
		this.sellerPhones = sellerPhones;
	}

}