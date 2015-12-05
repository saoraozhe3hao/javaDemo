package com.saoraozhe.hibernate;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.saoraozhe.hibernate.entity.Address;
import com.saoraozhe.hibernate.entity.Student;

//该类是用于测试Student表的入口，本例用的Hibernate版本4.3.11
public class SingleTableTest {
	private static SessionFactory sessionFactory;
	private static Session session;
	private static Transaction transaction;

	public static void main(String[] arg) throws Exception {
		open();
		// 增
//		Student studentSave = new Student(25);
//		studentSave.setAddress(new Address(710000, "雁塔"));
//		session.save(studentSave);
		// 改
//		Student studentUpdate = (Student) session.get(Student.class, 4);
//		studentUpdate.setAge(50);
//		session.update(studentUpdate);
		// 查
		Student studentGet = (Student) session.get(Student.class, 4);
		System.out.println(studentGet);
		// HQL，其中Student是类名，大小写敏感，只有from子句也能查询
		// 返回对象List，where过滤
		String hql1 = "from Student where age>50";
		Query query1 = session.createQuery(hql1);
		List<Student> students = query1.list();
		for (Student student : students) {
			System.out.println(student);
		}
		// 返回List<List>,distinct去重
		String hql2 = "select distinct new list(s.sid,s.age) from Student s";
		Query query2 = session.createQuery(hql2);
		List<List> lists = query2.list();
		for (List list : lists) {
			System.out.println(list.get(1));
		}
//		 返回List<Map> ，order by排序，默认升序，desc降序
		String hql3 = "select  new map(s.sid,s.age as age)from Student s order by s.age desc";
		Query query3 = session.createQuery(hql3);
		List<Map> maps = query3.list();
		for (Map map : maps) {
			System.out.println(map.get("0"));
			System.out.println(map.get("age"));
		}
		// 删
		// Student studentDelete = (Student) session.get(Student.class, 1);
		// session.delete(studentDelete);
		close();
	}

	public static void open() {
		// 获取配置对象，用于读取配置
		Configuration config = new Configuration().configure();
		// 获取登记对象
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(
				config.getProperties()).buildServiceRegistry();
		// 获取会话工厂
		sessionFactory = config.buildSessionFactory(registry);
		// 获取单例session，事务提交或回滚后会自动close
		// session = sessionFactory.getCurrentSession();
		// 获取新的session
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}

	public static void close() {
		// 提交事务
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
