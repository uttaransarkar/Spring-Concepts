package com.uttaran.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator 
	implements ConstraintValidator<CourseCode, String> {
	
	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode myCourseCode) {
		
		//gets the value from our custom annotation
		coursePrefix = myCourseCode.value();
	}

	@Override
	public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
		
		//this method is used to perform our own business logic
		
		//checking the data entered in the form field has valid prefix or not
		boolean res;
		
		if(code != null)
			res = code.startsWith(coursePrefix);
		else
			return true;
		return res;
	}

}
