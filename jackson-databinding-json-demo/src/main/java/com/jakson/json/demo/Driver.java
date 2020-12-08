package com.jakson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

/*-JSON TO POJO*/
public class Driver {

	public static void main(String[] args) {
		
		try {
			
			//create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			
			//read JSON file and map/convert to java PoJo;
			
			//data/sample-lite.json
			Student theStudent =
					mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			//print first name and last name
			System.out.println("First NAme:: "+theStudent.getFirstName());
			System.out.println("Last Name:: "+theStudent.getLastName());
			
			Address address = theStudent.getAddress();
			
			System.out.println("Street :: "+address.getStreet());
			System.out.println("Country :: "+address.getCountry());
			
			for(String lang :theStudent.getLanguages()) {
				
				System.out.println(lang);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
