package pl.migibud.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {

	private HibernateUtils() {
	}

	public static SessionFactory getSessionFactory() {
		return InstanceHolder.sessionFactory;
	}

	private static class InstanceHolder {
		private static StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		private static final SessionFactory sessionFactory = new MetadataSources(registry)
				.buildMetadata()
				.buildSessionFactory();
	}

}
