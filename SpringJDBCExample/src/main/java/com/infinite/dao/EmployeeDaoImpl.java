package com.infinite.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;

import com.infinite.helper.EmployeeRowMapper;
import com.infinite.interfaces.IEmployeeDao;
import com.infinite.pojo.Employee;

/**
 * @author karnatir these class is for DAO Implementation
 */
public class EmployeeDaoImpl implements IEmployeeDao {

	private DataSource dataSource = null;

	private JdbcTemplate jdbcTemplate = null;

	private PlatformTransactionManager transactionManager = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	// add unemployeedid in EmployeeDaoImpl

	public void createTable() {
		// TODO Auto-generated method stub
		
		String sql="create table employee (empid int primary key "
				+ "auto_increment,firstname varchar(25),"
				+ "lastname varchar(25),salary numeric(8,2))";
		jdbcTemplate.execute(sql);
		System.out.println("CreateTable");

	}

	public void insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		String sql="insert into employee(firstname,lastname,salary) "
				+ "values (?,?,?)";
		//var...args
		jdbcTemplate.update(sql, employee.getFirstname(), 
				employee.getLastname(), employee.getSalary());
		//jdbctemplate.update for insert into tabel
		System.out.println("Employee Record Inserted");

	}

	public void deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub
		String sql = "delete from employee where empid=?";
		 int c = jdbcTemplate.update(sql, new Object[] {employeeId });
		 if(c==0)
		System.out.println("Employee  Not Record Deleted");
		 else
			 System.out.println("Employee Record Deleted");

	}

	public List<Employee> getAllEmployees() {
		String sql="select * from employee";
		List<Employee> employee=jdbcTemplate.query(sql, 
				new EmployeeRowMapper(),new Object[] {});
		System.out.println("Showing all Employees");
		return employee;
	}
	

	public String findEmployeeName(int empId) {
		// TODO Auto-generated method stub
		System.out.println("Find Employee Name");
		return null;
	}

	public Employee findEmployee(int empId) {
		// TODO Auto-generated method stub
		System.out.println("Find  Employee");
		return null;
	}

	public int countEmployees() {
		// TODO Auto-generated method stub
		System.out.println("Count No Of Employee");
		return 0;
	}

	public void addbonus(Employee employee, int experience) {
		// TODO Auto-generated method stub
		System.out.println("Employee Bonus");

	}

}
