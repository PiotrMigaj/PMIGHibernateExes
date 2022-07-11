package pl.migibud.hibernate.onetoonesda;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.migibud.hibernate.HibernateUtils;
import pl.migibud.hibernate.model.Address;
import pl.migibud.hibernate.model.Student;
import pl.migibud.hibernate.model.StudentBook;
import pl.migibud.hibernate.model.User;

import java.time.LocalDate;

public class App1 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Student student = new Student("Piotr", "Migaj", LocalDate.now());
		StudentBook studentBook = new StudentBook("123");
		student.setStudentBook(studentBook);
		session.persist(student);

		transaction.commit();
		session.close();
	}
}
