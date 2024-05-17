package com.springmongo.Service;

import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.springmongo.Model.Student;
import com.springmongo.Repository.StudentRepository;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class MainService {
StudentRepository studentRepo;
	
	public MainService(StudentRepository studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}
	public void generateExcel(HttpServletResponse response) throws IOException {
		List<Student> students = studentRepo.findAll();
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Student Details");
		HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("Id");
		row.createCell(1).setCellValue("Name");
		row.createCell(2).setCellValue("Address");
		
		int dataRowIndex = 1;
		for( Student student: students) {
			HSSFRow dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(student.getRno());
			dataRow.createCell(1).setCellValue(student.getName());
			dataRow.createCell(2).setCellValue(student.getAddress());
			dataRowIndex++;
		}
		
		ServletOutputStream ops = response.getOutputStream();
		workbook.write(ops);
		workbook.close();
		ops.close();
	}
}
