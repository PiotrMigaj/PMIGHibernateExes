package pl.migibud.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.migibud.hibernate.HibernateUtils;
import pl.migibud.hibernate.model.Address;
import pl.migibud.hibernate.model.User;

public class App1 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Address address = new Address("Długa","Wrocław");
		User user = new User("migi987","migi987");
		user.setAddress(address);
		address.setUser(user);

		session.persist(user);

		transaction.commit();
		session.close();
	}
}
