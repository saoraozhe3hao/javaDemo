package com.saoraozhe.hibernate;

import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.saoraozhe.hibernate.entity.Company;
import com.saoraozhe.hibernate.entity.Employee;

//一对多关联，一方有一个成员是 多方的实体集合，在一方hbm.xml中配有set
public class OneToManyTest {

	public static void main(String[] arg) throws Exception {
//		add();
		findEmployeesByCompany();
//		update();
//		deleteEmployee();
	}


	public static void add(){
		Company company = new Company("乐送");
		Employee em1 = new Employee("张三", "男");
		Employee em2 = new Employee("李四", "女");
		//一对多关系中，把多方add到一方，更新多方时，会自动带上有效的一方的键，即多方的外键
		company.getEmployees().add(em1);
		company.getEmployees().add(em2);
		
		Session session = HibernateUtil.getSession();
		//一序列更新时，需要事务，使得失败时能将整个事务回滚
		Transaction transaction = session.beginTransaction();
		//一方跟数据库交互过，如查询、添加，使得一方实体对象获取到有效的键
		session.save(company);
		//hbm.xml中set的cascade为save-update时，以下两行可以不写
		session.save(em1);
		session.save(em2);
		transaction.commit();
		HibernateUtil.closeSession();
	}

	public static void findEmployeesByCompany(){
		Session session = HibernateUtil.getSession();
		//一方跟数据库交互过，如查询、添加，使得一方实体对象获取到有效的键
		Company company = (Company) session.get(Company.class, 4);
		System.out.println(company);
		//多方被用到时，才会实际去执行SQL语句
		Set<Employee> employees = company.getEmployees();
		for(Employee employee:employees){
			System.out.println(employee);
		}
		HibernateUtil.closeSession();
	}
	
	public static void update(){
		Company company = new Company("华为");
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Employee employee =(Employee) session.get(Employee.class, 1);
		//把多方add到一方，更新一方时，会同时更新多方的外键
		company.getEmployees().add(employee);
		//一方跟数据库交互过，如查询、添加，使得一方实体对象获取到有效的键
		session.save(company);
		transaction.commit();
		HibernateUtil.closeSession();
	}
	
	public static void deleteEmployee(){
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Employee employee =(Employee) session.get(Employee.class, 2);
		session.delete(employee);
		transaction.commit();
		HibernateUtil.closeSession();
	}
}
