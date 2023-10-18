package com.infinita.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infinite.service.CustomerService;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = 

		   new ClassPathXmlApplicationContext(new String[] {"Spring-AutoScan.xml"});
		   CustomerService cust = (CustomerService)context.getBean("customerService");
		   //System.out.println(cust);
		   cust.display();
		

	}

}
