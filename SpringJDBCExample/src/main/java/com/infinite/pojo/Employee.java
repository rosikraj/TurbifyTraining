package com.infinite.pojo;

import javax.validation.constraints.NotNull;

public class Employee {
	private int empId;
	private String firstname;
	private String lastname;
	@NotNull
	private double salary;
	// getters and setters

	public Employee() {
		// Un-parametrized constructor ( we created it)
	}

	public Employee(String firstname, String lastname, double salary) {
		// parametrized constructor ( we created it)
		// super();

		this.firstname = firstname;
		this.lastname = lastname;
		
		this.salary = salary;
	}

	public Employee(int empId, String firstname, String lastname, double salary) {
		super();
		this.empId = empId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
