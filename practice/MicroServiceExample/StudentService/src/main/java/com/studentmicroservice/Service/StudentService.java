package com.studentmicroservice.Service;

import org.springframework.stereotype.Service;

import com.studentmicroservice.Entity.Student;
import com.studentmicroservice.Repository.StudentRepository;

@Service
public class StudentService {

	private final StudentRepository studentRepo;
	
	public StudentService(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}
	
	public Student getStudentById(int id) {
		return studentRepo.findById(id).get();
	}
	
	public Student insert(Student student) {
		return studentRepo.save(student);
	}
}
