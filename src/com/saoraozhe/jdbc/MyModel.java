package com.saoraozhe.jdbc;

//模型层
public class MyModel {

	private Integer id;
	private String user_name;
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Goddess [id=" + id + ", user_name=" + user_name + ", age=" + age + "]";
	}
}
