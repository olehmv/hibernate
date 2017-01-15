package com.shop.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.IndexColumn;

@Entity
public class Basket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "basketId")
	private int basketId;
	 @ManyToMany(cascade=CascadeType.ALL)  
	    @JoinTable(name="basketPhones", joinColumns=@JoinColumn(name="basketId"), inverseJoinColumns=@JoinColumn(name="phoneId"))  
	private Collection<Phone> basketPhones = new ArrayList<>();

	public Basket() {
		super();
	}

	public int getBasketId() {
		return basketId;
	}

	public void setBasketId(int basketId) {
		this.basketId = basketId;
	}

	public Collection<Phone> getBasketPhones() {
		return basketPhones;
	}

	public void setBasketPhones(Collection<Phone> basketPhones) {
		this.basketPhones = basketPhones;
	}

}
