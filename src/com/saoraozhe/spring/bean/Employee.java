package com.saoraozhe.spring.bean;

public class Employee{
	private int age = 9;
	private String name;
	//薪水
	private int salary;
	
	public Employee(){
		
	}

	public Employee(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + "]";
	}
	
}
