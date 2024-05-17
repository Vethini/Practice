package com.springmongo.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmongo.Model.Student;
import com.springmongo.Repository.StudentRepository;
import com.springmongo.Service.MainService;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/student")
public class MainController {

//	@Autowired
	StudentRepository studentRepo;
	public MainController() {
		
	}
	
	public MainController(StudentRepository studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}
	@Autowired
	 MainService mainService;
	
//	public MainController(MainService mainService) {
//	
//		this.mainService=mainService;
//	}
//	
	@PostMapping("/add")
	public void addStudent(@RequestBody Student student) {
		studentRepo.save(student);
	}
	
	@GetMapping("/{id}")
	public Optional<Student> getStudent(@PathVariable String id) {
		return studentRepo.findById(id);
	}
	
	@GetMapping("/file")
	public void generateExcelReport(HttpServletResponse response) throws Exception{
		response.setContentType("application/vnd.ms-excel");
		String headerKey ="Content-Disposition";
		String headerValue = "attachment;filename=courses.xlsx";
		response.setHeader(headerKey, headerValue);
		mainService.generateExcel(response);		
	}
	
}
