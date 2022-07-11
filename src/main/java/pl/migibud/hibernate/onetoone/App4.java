package pl.migibud.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.migibud.hibernate.HibernateUtils;
import pl.migibud.hibernate.model.Address;
import pl.migibud.hibernate.model.User;

public class App4 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Address address = new Address("Kamienna","Suwałki");
		User user = new User("hela123","123456");
		address.setUser(user);

		session.persist(user);

		transaction.commit();
		session.close();
	}
}
