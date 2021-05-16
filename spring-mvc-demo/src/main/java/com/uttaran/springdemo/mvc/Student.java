package com.uttaran.springdemo.mvc;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Student {
	
	private String firstName;
	private String lastName;
	private String country;
	private String favLanguage;
	private String[] opSystem;
	
	//defining country options in class
	private HashMap<String, String> countries;
	
	public Student() {
		
		//this is being used to provide country options in our form using ISO code
		countries = new LinkedHashMap();
		countries.put("AU", "Australia");
		countries.put("BR", "Brazil");
		countries.put("DE", "Germany");
		countries.put("IN", "India");
		countries.put("SA", "South Africa");
		countries.put("US", "United States");
	
	}

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public HashMap<String, String> getCountries() {
		return countries;
	}

	public String getFavLanguage() {
		return favLanguage;
	}

	public void setFavLanguage(String favLanguage) {
		this.favLanguage = favLanguage;
	}

	public String[] getOpSystem() {
		return opSystem;
	}

	public void setOpSystem(String[] opSystem) {
		this.opSystem = opSystem;
	}
	
}
