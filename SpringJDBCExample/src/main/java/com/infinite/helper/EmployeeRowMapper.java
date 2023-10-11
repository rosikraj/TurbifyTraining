package com.infinite.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.infinite.pojo.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {
	public Employee mapRow(ResultSet rs, int count) throws SQLException {
		Employee employee = new Employee();
		employee.setEmpId(rs.getInt("empid"));
		employee.setFirstname(rs.getString("firstname"));
		employee.setLastname(rs.getString("lastname"));
		employee.setSalary(rs.getDouble("salary"));
		return employee;
	}

}
