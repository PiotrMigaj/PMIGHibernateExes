package pl.migibud.hibernate.onetomanysda;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.migibud.hibernate.HibernateUtils;
import pl.migibud.hibernate.model.Address;
import pl.migibud.hibernate.model.Client;
import pl.migibud.hibernate.model.Order;
import pl.migibud.hibernate.model.User;

import java.time.LocalDateTime;

public class App1 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Client client = new Client("Piotr","Migaj");
		session.persist(client);
		Order order1 = new Order(150,"Kosa", LocalDateTime.now());
		session.persist(order1);
		Order order2 = new Order(250,"Kosa spalinowa", LocalDateTime.now());
		session.persist(order2);

		client.addOrder(order1);
		client.addOrder(order2);

		transaction.commit();
		session.close();

	}
}
