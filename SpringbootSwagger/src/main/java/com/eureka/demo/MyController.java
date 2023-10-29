package com.eureka.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@RequestMapping(value="/api/hello")
	public String hello() {
		return "Welcome to Infinite ";
	}
	@RequestMapping(method=RequestMethod.GET,value="/api/hello1")
	public String hello1() {
		return "Welcome to Infinite 1";
	}

}
