package nz.ac.aut.sa.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil
{
	public static final SessionFactory sessionFactory;

	static
	{
		try
		{
			Configuration cfg = new Configuration()
				.configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(cfg.getProperties()).build();
			sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		}
		catch (Throwable ex)
		{
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static final ThreadLocal<Session> session
		= new ThreadLocal<Session>();

	public static Session currentSession()
		throws HibernateException
	{
		Session s = session.get();
		if (s == null)
		{
			s = sessionFactory.openSession();
			session.set(s);
		}
		return s;
	}

	public static void closeSession()
		throws HibernateException
	{
		Session s = session.get();
		if (s != null)
			s.close();
		session.set(null);
	}
}