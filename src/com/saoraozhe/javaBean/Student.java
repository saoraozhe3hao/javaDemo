package com.saoraozhe.javaBean;

//符合javaBean 特征的java类就是javaBean
public class Student{
	//javaBean特征：成员变量私有
	private int age = 9;
	
	//javaBean特征：有一个无参构造函数
	public Student(){
		
	}

	//javaBean特征：有getter 和 setter
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
