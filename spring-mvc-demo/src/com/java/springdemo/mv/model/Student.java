package com.java.springdemo.mv.model;

import java.util.LinkedHashMap;

import com.java.springdemo.mvc.validation.CourseCode;

public class Student {
	private String firstName;
	private String lastName;
	private String country;
	private String favoriteLanguage;
	private LinkedHashMap<String, String> contryOption;
	private LinkedHashMap<String, String> favoriteLanguageOption;
	private String[] operatingSystem;
	
	@CourseCode(value="LUV", message="start with LUV")
	private String courseCode;
	
	
	
	
	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}
	
	public String[] getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String[] operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public Student() {
		
		//populate country option: used ISO country code
		
		contryOption= new LinkedHashMap<String, String>();
		contryOption.put("IN","India");
		contryOption.put("BR","Brizil");
		contryOption.put("Fr","France");
		contryOption.put("DE","Germany");
		
		
		favoriteLanguageOption= new LinkedHashMap<String, String>();
		favoriteLanguageOption.put("JAVA","Java");
		favoriteLanguageOption.put("PHP","PHP");
		favoriteLanguageOption.put("C#","C#");
		favoriteLanguageOption.put("RUBY","Ruby");
		
		
	}
	
	public LinkedHashMap<String, String> getFavoriteLanguageOption() {
		return favoriteLanguageOption;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public LinkedHashMap<String, String> getContryOption() {
		return contryOption;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

}
