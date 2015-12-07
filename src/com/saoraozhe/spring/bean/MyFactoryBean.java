package com.saoraozhe.spring.bean;

import org.springframework.beans.factory.FactoryBean;

//实现Spring框架的 接口
public class MyFactoryBean implements FactoryBean<Employee> {
	
	private String name;

	public Employee getObject() throws Exception {
		return new Employee(name);
	}

	public Class<?> getObjectType() {
		return Employee.class;
	}

	//是否单例
	public boolean isSingleton() {
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
