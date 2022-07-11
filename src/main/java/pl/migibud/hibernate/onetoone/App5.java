package pl.migibud.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.migibud.hibernate.HibernateUtils;
import pl.migibud.hibernate.model.Address;
import pl.migibud.hibernate.model.User;

public class App5 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

//		Address address = session.get(Address.class, 1L);
//		session.remove(address);

//		Address address2 = session.get(Address.class, 5L);
//		session.remove(address2);
//
		User user = session.get(User.class, 1L);
		session.remove(user);

		transaction.commit();
		session.close();
	}
}
