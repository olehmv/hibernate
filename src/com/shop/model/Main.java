package com.shop.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		String[] n = { "oleg", "ivan", "igor" };
		String[] pn = { "23-34-667", "34-65-567", "23-45'678" };
		String[] zip = { "80300", "79000", "80344" };
		String[] ct = { "Zhovkva", "Lviv", "Viazova" };
		String[] str = { "str.Ypa 1", "str.Franka 54", "str.Lisova 6" };
		String[] pb = { "Nokia", "LG", "Lenovo" };
		String[] pm = { "N-70", "A-50", "V-1000" };
		Buyer b;
		for (int i = 0; i < pn.length; i++) {
			b = new Buyer(n[i], pn[i]);
			b.getBuyeraddresses().add(new HomeAddress(zip[i], ct[i], str[i]));
			b.getBuyerPhones().add(new Phone(pb[i], pm[i],(double)Math.random()+100*i));
			s.save(b);
		}
		// b = s.get(Buyer.class, 1);
		// for (Iterator iterator = b.getBuyeraddresses().iterator();
		// iterator.hasNext();) {
		// Address type = (Address) iterator.next();
		// System.out.println(type.toString());
		// }

		s.getTransaction().commit();
		s.close();
	}

}
