package com.shop.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		String[] n = { "oleg", "ivan", "igor" };
		String[] pn = { "23-34-667", "34-65-567", "23-45'678" };
		String[] zip = { "80300", "79000", "80344" };
		String[] ct = { "Zhovkva", "Lviv", "Viazova" };
		String[] str = { "str.Ypa 1", "str.Franka 54", "str.Lisova 6" };
		String[] pb = { "Nokia", "LG", "Lenovo" };
		String[] pm = { "N-70", "A-50", "V-1000" };
//		Buyer b = new Buyer(n[1], pn[1]);
//		Seller s = new Seller(n[0], pn[0]);
//		Basket bsk = new Basket();
//		b.setBuyerAddress(new BuyerAddress(zip[1], ct[1], str[1]));
//		s.setSellerAddress(new SellerAddress(zip[2], ct[2], str[2]));
//		s.getSellerPhones().add(new Phone(pb[0], pm[0], 456.5));
//		b.setBasket(bsk);
//		b.getBasket().getBasketPhones().addAll(s.getSellerPhones());
//		session.save(s);
//		session.save(b);
		
		//session.delete(session.get(Seller.class, 2));
		//session.get(Buyer.class, 3).getBasket().getBasketPhones().add(session.get(Phone.class, 2));

		for (int i = 0; i < pn.length; i++) {
			Buyer b = new Buyer(n[i], pn[i]);
			Seller s = new Seller(n[i], pn[i]);
			Basket bsk = new Basket();
			b.setBuyerAddress(new BuyerAddress(zip[i], ct[i], str[i]));
			s.setSellerAddress(new SellerAddress(zip[i], ct[i], str[i]));
			s.getSellerPhones().add(new Phone(pb[i], pm[i], (double) Math.random() + 100 * i));
			b.setBasket(bsk);
			b.getBasket().getBasketPhones().addAll(s.getSellerPhones());
			session.save(s);
			session.save(b);
			
		}

		session.getTransaction().commit();
		session.close();
	}

}
