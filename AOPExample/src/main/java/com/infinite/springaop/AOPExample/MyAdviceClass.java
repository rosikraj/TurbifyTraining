package com.infinite.springaop.AOPExample;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect // class level annotation
// in aspects we need to write methods
// there is no advice
public class MyAdviceClass {
	@Pointcut("execution(* com.infinite.springaop.*.*(..))")
	private void All() {
	}

	@Before("All") // method level annotation

	public void beforeAdvice() {
		System.out.println("Before advice executed.");
	}

	@After("All") // method level annotations

	public void afterAdvice() {
		System.out.println("After advice executed.");
	}

}
