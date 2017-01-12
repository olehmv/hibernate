package com.shop.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.IndexColumn;

@Entity
public class Buyer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int buyerId;
	@Column
	private String name;
	@Column
	private String phoneNumber;
	@SuppressWarnings("deprecation")
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "buyerId")
	@IndexColumn(name = "idx")
	private Collection<Address> buyeraddresses = new ArrayList<>();
	@SuppressWarnings("deprecation")
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "buyerId")
	@IndexColumn(name = "idx")
	private Collection<Phone> buyerPhones = new ArrayList<>();

	public Buyer() {
		super();
	}

	public Buyer(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
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

	public Collection<Address> getBuyeraddresses() {
		return buyeraddresses;
	}

	public void setBuyeraddresses(Collection<Address> buyeraddresses) {
		this.buyeraddresses = buyeraddresses;
	}

	public Collection<Phone> getBuyerPhones() {
		return buyerPhones;
	}

	public void setBuyerPhones(Collection<Phone> buyerPhones) {
		this.buyerPhones = buyerPhones;
	}

}
