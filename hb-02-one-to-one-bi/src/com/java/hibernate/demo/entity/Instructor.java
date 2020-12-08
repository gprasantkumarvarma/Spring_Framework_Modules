package com.java.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")

public class Instructor {

	// Steps by step mention below
	// Annotate the class as an entity and map to db table
	// annotate the fields with db column name
	// define the fields and mapping to instructionDetail entity
	// create constructions
	// generate getter/ setter methods
	// generate toSting() method

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="INSTRUCTOR_DETAIL_ID")
	private InstructorDetail instructionDetailID;
	
	
	public Instructor() {
		
	}


	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public InstructorDetail getInstructionDetailID() {
		return instructionDetailID;
	}


	public void setInstructionDetailID(InstructorDetail instructionDetailID) {
		this.instructionDetailID = instructionDetailID;
	}


	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", instructionDetailID=" + instructionDetailID + "]";
	}
	
	

}
