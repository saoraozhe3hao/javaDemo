package com.saoraozhe.spring.bean;

import java.util.List;
import java.util.Map;

public class Company {

	private String name;
	
	private Employee employee;
	
	private List<Employee> employees;
	
	private Map<String,Employee> employeeMap;

	public Company() {

	}


	public Company(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public List<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Map<String, Employee> getEmployeeMap() {
		return employeeMap;
	}


	public void setEmployeeMap(Map<String, Employee> employeeMap) {
		this.employeeMap = employeeMap;
	}


	@Override
	public String toString() {
		return "Company [name=" + name + ", employee=" + employee
				+ ", employees=" + employees + ", employeeMap=" + employeeMap
				+ "]";
	}
	
}
