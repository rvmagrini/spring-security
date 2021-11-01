package com.rvmagrini.springsecurity.student;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/school")
public class StudentController {
	
	private static final List<Student> STUDENTS = 
			Arrays.asList(
					new Student (1, "John Mayall"),
					new Student (2, "Jimmy Nolen"),
					new Student (3, "JJ Cale")
					);
	
	
	@GetMapping("/student/{studentId}")
	public Student getStudent(@PathVariable("studentId") Integer studentId) {
		return STUDENTS.stream()
				.filter(student -> studentId.equals(student.getStudentId()))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("Student " + studentId + " does not exist."));
	}

}
