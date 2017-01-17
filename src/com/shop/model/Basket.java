package com.shop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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

@Entity
public class Basket implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int basketId;
	@OneToOne(mappedBy = "basket", fetch = FetchType.LAZY)
	@JoinColumn(name = "buyerId")
	private Buyer buyer;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "basketPhones", joinColumns = @JoinColumn(name = "basketId"), inverseJoinColumns = @JoinColumn(name = "phoneId",nullable=true))
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

	public int getBasketId() {
		return basketId;
	}

	public void setBasketId(int basketId) {
		this.basketId = basketId;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void deletePhone(Phone phone) {
		for (Iterator<Phone> iterator = basketPhones.iterator(); iterator.hasNext();) {
			Phone ph =  iterator.next();
			if (ph == phone) {
				basketPhones.remove(ph);
			}

		}
	}
}
