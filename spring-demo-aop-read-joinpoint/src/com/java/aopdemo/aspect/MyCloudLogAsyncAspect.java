package com.java.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyCloudLogAsyncAspect {
	
	//@Before("forDaoPackage()")
	@Before("com.java.aopdemo.aspect.LuvAopPointcutDeclarationUtil.forDaoPackageNoGetterSetter()")
	public void logToCloudAsync() {

		System.out.println("\n==========>> logToCloudAsync");
	}

}
