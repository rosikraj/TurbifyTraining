package com.infinite.H2DemoExample9.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinite.H2DemoExample9.model.Employee;
import com.infinite.H2DemoExample9.repository.EmployeeRepository;



@Service
public class EmployeeService {
	@Autowired
    EmployeeRepository empRepository;

	//CREATE
	public Employee createEmployee(Employee emp) {
	    return empRepository.save(emp);
	}

	//READ
	public List<Employee> getEmployees() {
	    return empRepository.findAll();
	}

}
