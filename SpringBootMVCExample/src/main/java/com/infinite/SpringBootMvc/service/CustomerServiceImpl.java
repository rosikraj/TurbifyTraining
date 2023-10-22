package com.infinite.SpringBootMvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infinite.SpringBootMvc.model.Customer;
import com.infinite.SpringBootMvc.repository.CustomerDaoImpl;

@Service
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	CustomerDaoImpl cdo;
	// add class

	@Override
	@Transactional
	// add transactional
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		
		return cdo.getAllCustomers();
	}

	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		cdo.addCustomer(customer);
	}

	@Override
	@Transactional
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		cdo.updateCustomer(customer);
		
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		cdo.deleteCustomer(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return cdo.getCustomer(id);
	}

}
