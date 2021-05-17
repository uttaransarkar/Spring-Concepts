package com.uttaran.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)

public @interface CourseCode {
		
	//defining default course code
	public String value() default "UTT";
	
	//defining default error message
	public String message() default "must start with UTT";
	
	//defining default groups, if there are related constraints to be grouped
	public Class<?>[] groups() default {};

	//defining default payloads
	public Class<? extends Payload>[] payload() default {};
	
}