package pl.migibud.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.migibud.hibernate.HibernateUtils;
import pl.migibud.hibernate.model.Address;
import pl.migibud.hibernate.model.Customer;
import pl.migibud.hibernate.model.SalesRep;
import pl.migibud.hibernate.model.User;

public class App1 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Customer customer = new Customer("Piotr");
		Customer customer2 = new Customer("Ania");

		session.persist(customer);
		session.persist(customer2);

		SalesRep salesRep = new SalesRep("Maciek");
		salesRep.addCustomer(customer);
		salesRep.addCustomer(customer2);

		session.persist(salesRep);


		transaction.commit();
		session.close();
	}
}
