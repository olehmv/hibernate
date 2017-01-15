package com.shop.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.IndexColumn;

@Entity
public class Basket {
	@Id
	@GeneratedValue
	@Column(name="backetPk")
	private int basketId;
//	@OneToOne
//	@JoinColumn(name = "buyerId", insertable = false, updatable = false)
//	private Buyer buyer;
//	@OneToMany(mappedBy = "basket", cascade = CascadeType.ALL)
//	@ElementCollection
//    @JoinColumn(name = "basketFK")
	@SuppressWarnings("deprecation")
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name="basketId")
	@IndexColumn(name = "idx")
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
