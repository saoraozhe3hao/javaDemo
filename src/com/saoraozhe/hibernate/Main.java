package com.saoraozhe.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

//该类是用于测试的入口，本例用的Hibernate版本4.3.11
public class Main {
	private static SessionFactory sessionFactory;
	private static Session session;
	private static Transaction transaction;

	public static void main(String[] arg) throws Exception {
		open();
		//增
		Student studentSave = new Student(25);
		studentSave.setAddress(new Address(710000,"雁塔"));
		session.save(studentSave);
		//改
		Student studentUpdate = (Student) session.get(Student.class, 1);
		studentUpdate.setAge(50);
		session.update(studentUpdate);
		//查
		Student studentGet = (Student) session.get(Student.class, 1);
		System.out.println(studentGet);
		//删
		Student studentDelete = (Student) session.get(Student.class, 1);
		session.delete(studentDelete);
		close();
	}

	public static void open() {
		//获取配置对象，用于读取配置
		Configuration config = new Configuration().configure();
		//获取登记对象
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		sessionFactory = config.buildSessionFactory(registry);
		//获取单例session，事务提交或回滚后会自动close
		//session = sessionFactory.getCurrentSession();
		//获取新的session
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}

	public static void close() {
		//提交事务
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
