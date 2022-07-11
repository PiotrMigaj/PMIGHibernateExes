package pl.migibud.hibernate.onetoonesda;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.migibud.hibernate.HibernateUtils;
import pl.migibud.hibernate.model.Student;
import pl.migibud.hibernate.model.StudentBook;

import java.time.LocalDate;

public class App2 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		StudentBook studentBook = session.get(StudentBook.class, 1L);
		studentBook.getStudent().setFirstName("Anna");

		transaction.commit();
		session.close();
	}
}
