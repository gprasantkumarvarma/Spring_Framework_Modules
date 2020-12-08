package com.java.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
public class LuvAopPointcutDeclarationUtil {
	
	@Pointcut("execution(* com.java.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {

	}

	// create point cut for getter method
	@Pointcut("execution(* com.java.aopdemo.dao.*.get*(..))")
	public void getter() {

	}

	// create point cut for setter method
	@Pointcut("execution(* com.java.aopdemo.dao.*.set*(..))")
	public void setter() {

	}

	// create point cut : include package ..exclude getter/ setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {
		
	}

}
