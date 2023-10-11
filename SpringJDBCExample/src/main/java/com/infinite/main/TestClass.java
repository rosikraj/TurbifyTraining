package com.infinite.main;

import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infinite.dao.EmployeeDaoImpl;
import com.infinite.pojo.Employee;

public class TestClass {
	public static void main(String[] args) {

		ApplicationContext context =

				new ClassPathXmlApplicationContext("JdbcBeans.xml");

		EmployeeDaoImpl daoImpl =

				(EmployeeDaoImpl) context.getBean("empDaoImpl");

		// daoImpl.createTable();

		/*Employee employee = new Employee();
		employee.setFirstname("Kamal");
	    employee.setLastname("Emi");
		employee.setSalary(2300);
		Employee employee2 = new Employee("Emi", "Jack", 34000)*/;
		
		
		Iterator <Employee> It = daoImpl.getAllEmployees().iterator();
		while(It.hasNext())
		{
			System.out.println(It.next().getFirstname());
		}
		while(It.hasNext())
		{
			System.out.println(It.next().getLastname());
		}
		//daoImpl.insertEmployee(employee);
		//daoImpl.insertEmployee(employee2);
		
		//daoImpl.createTable();
		daoImpl.deleteEmployee(5);
		
	}

}
