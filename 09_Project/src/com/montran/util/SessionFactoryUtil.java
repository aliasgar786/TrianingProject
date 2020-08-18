package com.montran.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryUtil {
	private static SessionFactory sessionFactory;
	static {
		try {
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			System.out.println("sessionFactory created");
		} catch (Exception e) {
			System.out.println("Exception while creating sessionFactory");
			e.printStackTrace();
		}
	}

	public static SessionFactory getFactory() {
		return sessionFactory;
	}
}
