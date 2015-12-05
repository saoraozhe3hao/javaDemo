package com.saoraozhe.hibernate.entity;

import java.io.Serializable;

public class Employee implements Serializable {

	private int eid;
	private String ename;
	private String sex;
	//多对一关联关系中，多方有一个成员是多方实体对象
    Company company;

	public Employee() {

	}

	public Employee(String ename, String sex) {
		this.ename = ename;
		this.sex = sex;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", sex=" + sex
				+ "]";
	}
	
}
