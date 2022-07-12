package pl.migibud.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.migibud.hibernate.HibernateUtils;
import pl.migibud.hibernate.model.Client;
import pl.migibud.hibernate.model.Customer;
import pl.migibud.hibernate.model.Order;
import pl.migibud.hibernate.model.SalesRep;

public class App3 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Order order = session.get(Order.class, 1L);
		Client client = order.getClient();
		client.setFirstName("Anna");
		System.out.println(client);


		transaction.commit();
		session.close();
	}
}
