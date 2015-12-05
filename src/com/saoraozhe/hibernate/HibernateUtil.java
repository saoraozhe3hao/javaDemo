package com.saoraozhe.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	private static Session session;
	
	static{
		Configuration config = new Configuration().configure();
		StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
		StandardServiceRegistry registry = registryBuilder.build();
		sessionFactory = config.buildSessionFactory(registry);
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}

	public static Session getSession(){
		session = sessionFactory.openSession();
		return session;
	}
	
	public static void closeSession(){
		if(session!=null){
			session.close();
		}
	}
	
	//清除会话缓存（一级缓存）。hibernate会将查询的结果缓存起来，下次查询命中缓存时，就不去数据库查询了
	public static void clearCache(){
		if(session!=null){
			session.clear();
		}
	}
}
