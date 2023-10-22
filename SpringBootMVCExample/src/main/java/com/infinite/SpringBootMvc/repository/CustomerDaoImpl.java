	package com.infinite.SpringBootMvc.repository;



import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infinite.SpringBootMvc.model.Customer;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

	@Autowired
	private SessionFactory	 sfactory;
	
	public void setSfactory(SessionFactory sfactory) {
		this.sfactory = sfactory;
	}
	//only setters 

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		Session scs =this.sfactory.getCurrentSession();
		List <Customer> ls = scs.createQuery("from Customer").list();
		// <Customer> pojo class
		// for returning we use List
		//or.hibernate for session import
		//this means current session
		return ls;
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = this.sfactory.getCurrentSession();
		Customer customer = (Customer) session.get(Customer.class, id);
		return customer;
		// TODO Auto-generated method stub
	}

	@Override
	public Customer addCustomer(Customer customer) {

		Session session = this.sfactory.getCurrentSession();

				session.save(customer);

				return customer;

	}

	@Override
	public void updateCustomer(Customer customer) {

		Session session = this.sfactory.getCurrentSession();

				Hibernate.initialize(customer);

				session.update(customer);
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCustomer(int id) {
		Session session = this.sfactory.getCurrentSession();
		Customer p = (Customer) session.load(Customer.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}
		// TODO Auto-generated method stub

	}


