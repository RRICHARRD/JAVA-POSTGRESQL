//https://www.devmedia.com.br/persistindo-objetos-com-java-hibernate-e-postgresql/4149

package com.example.main;

import org.hibernate.*;
import org.hibernate.cfg.*;

import com.example.entity.Customers;

public class MainHibernate {
	
	public static void main(String[] args) {
		Customers customer = new Customers();

		customer.setId(6);
		customer.setName("Barack Obama");;
		customer.setAge(55);
		customer.setAddress("USA");
		customer.setSalary(35000);

		SessionFactory factory = factory(customer);
		Session session = null;
		Transaction tx = null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(customer);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			System.out.println("Transaction failed: ");
			e.printStackTrace();
		} finally {
			session.close();
		}
}

	private static SessionFactory factory(Object classe){
		Configuration  config = new Configuration().
				setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect").
				setProperty("hibernate.connection.driver_class", "org.postgresql.Driver").
				setProperty("hibernate.connection.url","jdbc:postgresql://localhost:5432/example").
				setProperty("hibernate.connection.username", "postgres").
				setProperty("hibernate.connection.password", "123abc").
				setProperty("hibernate.show_sql", "true");

		config.addClass(((Customers)classe).getClass());

      return config.buildSessionFactory();
	}
}
