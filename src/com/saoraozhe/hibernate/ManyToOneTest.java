package com.saoraozhe.hibernate;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.saoraozhe.hibernate.entity.Company;
import com.saoraozhe.hibernate.entity.Employee;

//多对一关联，多方有一个成员是 一方实体对象，在一方hbm.xml中配有many-to-one
public class ManyToOneTest {

	public static void main(String[] arg) throws Exception {
//		add();
		findCompanyByEmployee();
	}

	public static void add() {
		Company company = new Company("中兴");
		Employee em1 = new Employee("慕女神", "女");
		Employee em2 = new Employee("小慕慕", "男");

		//多对一关系中，在多方指定一方，更新多方时，会自动带上有效的一方的键，即多方的外键
		em1.setCompany(company);
		em2.setCompany(company);

		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		//一方跟数据库交互过，如查询、添加，使得一方实体对象获取到有效的键
		//hbm.xml中many-to-one的cascade为save-update时，以下一行可以不写
		session.save(company);
		session.save(em1);
		session.save(em2);
		transaction.commit();
		HibernateUtil.closeSession();
	}
	
	public static void findCompanyByEmployee(){
		Session session = HibernateUtil.getSession();
		Employee employee = (Employee) session.get(Employee.class, 1);
		//一方被用到时，才会实际去执行SQL语句
		Company company = employee.getCompany();
		System.out.println(company);
		HibernateUtil.closeSession();
	}
}
