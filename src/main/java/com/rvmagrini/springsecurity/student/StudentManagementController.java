package com.rvmagrini.springsecurity.student;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/management/school")
public class StudentManagementController {
	
	private static final List<Student> STUDENTS = 
			Arrays.asList(
					new Student (1, "John Mayall"),
					new Student (2, "Jimmy Nolen"),
					new Student (3, "JJ Cale")
					);
	
	@GetMapping
	public List<Student> getAllStudents() {
		System.out.println("getAllStudents");
		return STUDENTS;
	}
	
	@PostMapping
	public void registerNewStudent(@RequestBody Student student) {
		System.out.println("New Student: " + student);
	}
	
	@DeleteMapping("/student/{studentId}")
	public void deleteStudent(@PathVariable("studentId") Integer studentId) {
		System.out.println("Deleted Id: " + studentId);
	}
	
	@PutMapping("/student/{studentId}")
	public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student) {
		System.out.println("Updated Id: " + String.format("%s %s", studentId, student));
	}

}
