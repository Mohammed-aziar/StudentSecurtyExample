package com.ExampeStudentSecurity;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
	
	
	private static final List<Student> students= Arrays.asList(new Student(1, "mohammed"),new Student(2, "test2"),new Student(3, "test2"));
	
	

	@GetMapping(path = "{studentsId}")
	public Student getStudent(@PathVariable("studentsId") Integer studentID) {
		
		return students.stream()
				.filter(student -> studentID.equals(student.getStudentId()))
						.findFirst()
						.orElseThrow(()-> new IllegalStateException("Student with id "+studentID+" does not existe") );
				
	}
}
