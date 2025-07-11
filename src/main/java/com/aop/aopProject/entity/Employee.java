package com.aop.aopProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer empid;
	private String name;
	
	
	
	public Employee() {
		super();
	}
	public Employee(Integer empid, String name) {
		super();
		this.empid = empid;
		this.name = name;
	}
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
