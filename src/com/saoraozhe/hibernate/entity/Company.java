package com.saoraozhe.hibernate.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Company implements Serializable {

	private int cid;
	private String cname;
	//一对多关联关系中，一方有一个成员是多方的实体集合
	Set<Employee> employees = new HashSet<Employee>();
	

	public Company() {

	}


	public Company(String cname) {
		super();
		this.cname = cname;
	}


	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}


	@Override
	public String toString() {
		return "Company [cid=" + cid + ", cname=" + cname + ", employees="
				+ employees + "]";
	}

}
