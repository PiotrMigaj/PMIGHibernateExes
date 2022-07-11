package pl.migibud.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.migibud.hibernate.HibernateUtils;
import pl.migibud.hibernate.model.User;

public class App2 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		User user = session.get(User.class, 1L);
		System.out.println(user);


		transaction.commit();
		session.close();
	}
}
