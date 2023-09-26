package com.infinite.Log4j_Example;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Example1 {

	 private static final Logger logger //2nd logger first letter l is small letter
    = Logger.getLogger(Example1.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Hi Hello World");
		logger.warn("pls dont use it");
		logger.error("Some error occured");
		logger.fatal("Fatal error");
		

	}

}
