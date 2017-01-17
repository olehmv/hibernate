package com.shop.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.IndexColumn;

@Embeddable
public class Basket {
	@OneToMany(cascade=CascadeType.DETACH)
	@JoinTable(name = "basketPhones",joinColumns = @JoinColumn(name = "buyerId"), inverseJoinColumns = @JoinColumn(name = "phoneId"))
	private Collection<Phone> basketPhones = new ArrayList<>();

	public Basket() {
		super();
	}

	public Collection<Phone> getBasketPhones() {
		return basketPhones;
	}

	public void setBasketPhones(Collection<Phone> basketPhones) {
		this.basketPhones = basketPhones;
	}

}
