package com.saoraozhe.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.saoraozhe.spring.bean.Company;
import com.saoraozhe.spring.bean.Employee;

public class IocTest {
	
	public static void main(String[] args) {
	
		//ApplicationContext即IOC容器
		//ClassPathXmlApplicationContext 是 ApplicationContext的一个实现类，从Class目录下读取bean配置文件
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/saoraozhe/spring/bean/iocBean.xml");
		//从框架获取bean对象，而非创建，即IOC，控制反转
		//根据配置文件中设置的bean的id来获取bean对象
		Employee employee = (Employee) ctx.getBean("employee");		
		//根据类名来获取bean对象
//		Student student = (Student) ctx.getBean(Student.class);	
		//获取bean时，成员被初始化。即DI，依赖注入
		//配置文件中constructor-arg，即构造器注入，property即属性注入
		System.out.println(employee);
		
		
		Company company1 = (Company) ctx.getBean("company1");		
		System.out.println(company1);
		
		Company company2 = (Company) ctx.getBean("company2");		
		System.out.println(company2);
		
		Employee employee1 = (Employee) ctx.getBean("employeeFactory");		
		System.out.println(employee1);
		
		Company company3 = (Company) ctx.getBean("factoryCompany");		
		System.out.println(company3);
		
		Employee employee2 = (Employee) ctx.getBean("EmployeeFactoryBean");		
		System.out.println(employee2);
		
		ctx.close();
	}
	
}
