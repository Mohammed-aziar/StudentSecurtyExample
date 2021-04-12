package com.ExampeStudentSecurity;

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
@RequestMapping("/mangement/api/v2/students/")
public class StudentControllerMangement {

	private static final List<Student> students= Arrays.asList(new Student(1, "mohammed"),new Student(2, "test2"),new Student(3, "test2"));
	@GetMapping
	public List<Student> getAllStudents(){
		return students;
	}
	
	@PostMapping
	public void addStudent(@RequestBody Student student) {
		System.out.println(student);
	}
	
	@DeleteMapping(path = "{idStudent}")
	public void detleteStudent(@PathVariable("idStudent") Integer idStudent) {
		System.out.println(idStudent);
	}
	
	
	@PutMapping(path = "{idStudent}")
	public void updata(@PathVariable("idStudent") Integer idStudent,@RequestBody Student student) {
		System.out.println(student);
	}
	
}
