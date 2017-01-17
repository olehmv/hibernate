package com.shop.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

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

		//session.delete(session.get(Seller.class, 3));

		//session.delete(session.get(Buyer.class, 2));
		
//		for (int i = 0; i < pn.length; i++) {
//			Seller s = new Seller(n[i], pn[i]);
//			s.setSellerAddress(new SellerAddress(zip[i], ct[i], str[i]));
//			s.getSellerPhones().add(new Phone(pb[i], pm[i], (double) Math.random() + 100 * i));
//			s.getSellerPhones().add(new Phone(pb[i], pm[i], (double) Math.random() + 100 * i));
//			Buyer b = new Buyer(n[i], pn[i]);
//			b.setBuyerAddress(new BuyerAddress(zip[i], ct[i], str[i]));
//			b.getBasket().getBasketPhones().addAll(s.getSellerPhones());
//			session.save(s);
//			session.save(b);
//		}
		
		Buyer b=session.get(Buyer.class, 1);
		Collection<Phone> p=b.getBasket().getBasketPhones();
		for (Iterator<Phone> iterator = p.iterator(); iterator.hasNext();) {
			Phone phone = iterator.next();
			System.out.println(phone.toString());
			b.getBasket().deletePhone(phone);
			System.out.println(phone.toString()+"deleted");

			
		}
		session.save(b);

		session.getTransaction().commit();
		session.close();
	}

}
