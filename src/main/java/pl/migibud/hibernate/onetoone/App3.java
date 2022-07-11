package pl.migibud.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.migibud.hibernate.HibernateUtils;
import pl.migibud.hibernate.model.Address;

public class App3 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Address address = session.get(Address.class, 1L);
		address.getUser().setUsername("STEFAN_123");
		address.setUser(null);
		System.out.println(address);

		transaction.commit();
		session.close();
	}
}
