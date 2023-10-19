package com.infinite.H2DemoExample9.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.H2DemoExample9.model.Employee;
import com.infinite.H2DemoExample9.service.EmployeeService;




@RestController
@RequestMapping("/api/vi")
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	@RequestMapping(value="/employees", method=RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee emp) {
		System.out.println("creating a table employee");
	    return empService.createEmployee(emp);
	}
	@RequestMapping(value="/employees", method=RequestMethod.GET)
	public List<Employee> readEmployees() {
		System.out.println("read employee");
	    return empService.getEmployees();
	}

}
