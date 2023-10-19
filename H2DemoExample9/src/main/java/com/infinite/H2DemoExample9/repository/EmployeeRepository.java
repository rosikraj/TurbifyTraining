package com.infinite.H2DemoExample9.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infinite.H2DemoExample9.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	

}
