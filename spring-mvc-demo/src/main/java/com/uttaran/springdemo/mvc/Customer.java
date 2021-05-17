package com.uttaran.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.uttaran.springdemo.mvc.validation.CourseCode;

public class Customer {
	
	//validation rules for firstName
	@NotNull(message = "required field")
	@Size(min = 1, message = "required field")
	private String firstName;
	
	private String lastName;
	
	@NotNull(message = "required field")
	@Min(value = 0, message = "enter value between 0-10")
	@Max(value = 10, message = "enter value between 0-10")
	private Integer noOfPasses;
	
	//applying regular expression validation for 5 digit postal code matching
	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "must be of 5 characters having digits/alphabets")
	private String postalCode;
	
	@CourseCode			//this is our custom annotation
	private String courseCode;
	
	
	//getters and setters
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Integer getNoOfPasses() {
		return noOfPasses;
	}
	public void setNoOfPasses(Integer noOfPasses) {
		this.noOfPasses = noOfPasses;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
}
