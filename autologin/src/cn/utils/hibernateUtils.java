package cn.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernateUtils {
private static Configuration configurantion;
private static SessionFactory sessionFactory;
	private static Session session;
	public static Session getSession() {
		configurantion=new Configuration().configure();
		sessionFactory=configurantion.buildSessionFactory();
	    session=sessionFactory.openSession();
		return session;
	}
	
	
}
