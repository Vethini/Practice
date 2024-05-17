package com.studentmicroservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.studentmicroservice.Entity.Library;
import com.studentmicroservice.Entity.Student;
import com.studentmicroservice.Service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private RestTemplate restTemplate;
	
	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable int id){
		
		Library library = restTemplate.getForObject("http://localhost:9002/library/"+id,Library.class);
	
		Student student =  studentService.getStudentById(id);
		student.setLibrary(library);
		return student;
	}
	
	@PostMapping("")
	public Student insertStudent(@RequestBody Student student) {
		return studentService.insert(student);
	}
}
