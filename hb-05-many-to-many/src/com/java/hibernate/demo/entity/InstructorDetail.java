package com.java.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

	//Steps by step mention below
	//Annotate the class as an entity and map to db table 
	//define the fields
	//annotate the fields with db column name
	//create constructions
	//generate getter/ setter methods
	//generate toSting() method
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="YOUTUBE_CHANNEL")
	private String youtubeChannel;
	
	@Column(name="HOBBY")
	private String hobby;
	
	/**
	 * bi-directional example
	 * mappedBy tells Hibernate
	 * . Look at the instructionDetailID property in the Instructor class
	 * . use information from the Instructor class @JoinColumn to find associated instructor
	 * 
	 * */
	//@OneToOne(mappedBy="instructionDetailID",cascade = CascadeType.ALL)
	@OneToOne(mappedBy="instructionDetailID",cascade = {CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.REFRESH})
	private Instructor instructor;
	
	
	public InstructorDetail() {
		
	}


	public InstructorDetail(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getYoutubeChannel() {
		return youtubeChannel;
	}


	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}


	public String getHobby() {
		return hobby;
	}


	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	


	public Instructor getInstructor() {
		return instructor;
	}


	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}


	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}




	
	
	
	
	
}
