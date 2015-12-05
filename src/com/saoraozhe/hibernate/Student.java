package com.saoraozhe.hibernate;

//Hibernate的实体类（持久化类）符合javaBean 特征
public class Student{
	
	private int sid;
	private int age = 9;
	private Address address;
	
	public Student(){
		
	}

	public Student(int age) {
		this.age = age;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", age=" + age + ", address=" + address
				+ "]";
	}
	
}
