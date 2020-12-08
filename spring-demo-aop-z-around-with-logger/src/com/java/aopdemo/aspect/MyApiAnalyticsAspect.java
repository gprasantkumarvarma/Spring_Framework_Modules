package com.java.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyApiAnalyticsAspect {
	
	//@Before("forDaoPackage()")
		@Before("com.java.aopdemo.aspect.LuvAopPointcutDeclarationUtil.forDaoPackageNoGetterSetter()")
		public void performAnalytics() {

			System.out.println("\n==========>> performace API analytics");
		}


}
