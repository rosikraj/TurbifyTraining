package com.infinite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infinite.dao.DaoExample;

@Service
public class CustomerService {
	@Autowired
	// it is for variable
	// it will reduce max lines of xml tags
	// autowired not support primitive datatype
	// in layered approach we use these
	DaoExample daoExample;

	// import daoExample
	// @Override
	public void display() {
		daoExample.display();
		System.out.println("customer service activated ");
	}

}
