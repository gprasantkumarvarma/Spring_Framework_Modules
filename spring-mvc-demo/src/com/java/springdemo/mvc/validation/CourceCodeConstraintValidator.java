package com.java.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourceCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;

	@Override
	public void initialize(CourseCode thCource) {
		coursePrefix = thCource.value();
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext context) {

		boolean result ;
		if(theCode != null) {
		 result = theCode.startsWith(coursePrefix);
		}
		else {
			result= true;
		}

		return result;
	}

}
