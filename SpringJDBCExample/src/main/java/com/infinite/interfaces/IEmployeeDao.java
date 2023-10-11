package com.infinite.interfaces;

import java.util.List;

import com.infinite.pojo.Employee;
 // create a new interface class
// import all the package we need to use ( ctrl+shift+o import all ( util)

public interface IEmployeeDao {
	public void createTable();

	public void insertEmployee(Employee employee);

	public void deleteEmployee(int employeeId);

	public List<Employee> getAllEmployees();

	public String findEmployeeName(int empId);

	public Employee findEmployee(int empId);

	public int countEmployees();

	// public String callProcedure(int empid);
	public void addbonus(Employee employee, int experience);

}
