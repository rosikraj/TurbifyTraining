package com.infinite.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Log4j_Display {
	private static final Logger logger //2nd logger first letter l is small letter
    = Logger.getLogger(Log4j_Display.class);


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("Infinite Solutions");
		logger.info("Java Backend");

	}

}
