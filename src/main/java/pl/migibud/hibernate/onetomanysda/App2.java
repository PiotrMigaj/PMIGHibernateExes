package pl.migibud.hibernate.onetomanysda;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.migibud.hibernate.HibernateUtils;
import pl.migibud.hibernate.model.Client;
import pl.migibud.hibernate.model.Order;

import java.time.LocalDateTime;

public class App2 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Client client = session.get(Client.class, 1L);

		Order order = new Order(245, "cos nowego", LocalDateTime.now());
		session.persist(order);

		client.getOrders().add(order);

		transaction.commit();
		session.close();

	}
}
