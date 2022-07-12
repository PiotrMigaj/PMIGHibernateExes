package pl.migibud.hibernate2.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.migibud.hibernate.HibernateUtils;
import pl.migibud.hibernate2.model.Client;
import pl.migibud.hibernate2.model.Orders;

import java.time.LocalDateTime;

public class App2 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Orders orders = session.get(Orders.class, 2);
		orders.getClients().stream().peek(v-> v.setFirstName("Mirosław")).forEach(System.out::println);

		transaction.commit();
		session.close();
	}
}
