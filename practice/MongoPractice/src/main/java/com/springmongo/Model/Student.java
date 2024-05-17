package com.springmongo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student {

	@Id
	private String rno;
	private String name;
	private String address;
	public String getRno() {
		return rno;
	}
	public void setRno(String rno) {
		this.rno = rno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Student(String rno, String name, String address) {
		super();
		this.rno = rno;
		this.name = name;
		this.address = address;
	}
	
	public Student() {
		super();
	}
	
	
}
