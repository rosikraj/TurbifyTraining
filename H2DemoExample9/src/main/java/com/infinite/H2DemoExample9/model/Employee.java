package com.infinite.H2DemoExample9.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name ="employee")
public class Employee {
	@Id
	@Column(name="Emp_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empid;

	@Column(name="First_Name")
	private String fname;

	@Column(name="Last_Name")
	private String lname;

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

}
