package in.hirbernet.utill;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.hirbernet.model.Studentdata;

public class Utill {

	private static SessionFactory sessionFactory;
	private static Session session;

	static {
		sessionFactory = new Configuration().configure().addAnnotatedClass(Studentdata.class).buildSessionFactory();
	}
	public static Session getsession() {
		session = sessionFactory.openSession();
		return session;
	}
	public static void closesession() {
		session.close();
	}
	public static void closessionFactory() {
		sessionFactory.close();
	}
}
