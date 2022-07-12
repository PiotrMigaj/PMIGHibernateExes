package pl.migibud.hibernate2.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.migibud.hibernate.HibernateUtils;
import pl.migibud.hibernate2.model.Client;
import pl.migibud.hibernate2.model.Orders;

import java.time.LocalDateTime;

public class App1 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Client client = new Client("Piotr","Migaj");
		Client client2 = new Client("Anna","Migaj");
		Orders order = new Orders(150,"kosa", LocalDateTime.now());
		Orders order2 = new Orders(150,"kosa2", LocalDateTime.now());
		Orders order3 = new Orders(150,"kosa4", LocalDateTime.now());

//		session.persist(order);
//		session.persist(order2);
//		session.persist(order3);


		client.getOrders().add(order);
		client.getOrders().add(order2);

		client2.getOrders().add(order2);
		client2.getOrders().add(order3);

		order.getClients().add(client);
		order2.getClients().add(client);
		order2.getClients().add(client2);
		order3.getClients().add(client2);

		session.persist(client);
		session.persist(client2);

		transaction.commit();
		session.close();
	}
}
