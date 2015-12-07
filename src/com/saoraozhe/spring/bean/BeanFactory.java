package com.saoraozhe.spring.bean;

public class BeanFactory {

	public static Employee getEmployee(String name){
		return new Employee(name);
	}
	
	public Company getCompany(String name){
		return new Company(name);
	}
}
