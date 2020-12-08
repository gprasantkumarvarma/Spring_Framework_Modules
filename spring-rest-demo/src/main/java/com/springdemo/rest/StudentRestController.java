package com.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.rest.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	private List<Student> theStudent;

	// define @PostConstruct to load the student data...(@PostConstructs only loads
	// once when bean is constructed)
	@PostConstruct
	public void loadData() {
		theStudent = new ArrayList<Student>();
		theStudent.add(new Student("keerthi", "Matha"));
		theStudent.add(new Student("prasant", "varna"));
		theStudent.add(new Student("jyoti", "D"));
		theStudent.add(new Student("keran", "Matha"));
		theStudent.add(new Student("vinay", "D"));
	}

	// define endpoin for "/students"- return list of sudent

	@GetMapping("/students")
	public List<Student> getStudents() {

		return theStudent;

	}

	@GetMapping("/students/{studentId}")
	public Student getSudent(@PathVariable int studentId) {

		// check the student ID against list size
		if (studentId >= theStudent.size() || (studentId < 0)) {
			throw new StudentNotFoundException("Student is not fount -" + studentId);
		}

		// just index into the list ...keep its simple now

		return theStudent.get(studentId);
	}

	

}
