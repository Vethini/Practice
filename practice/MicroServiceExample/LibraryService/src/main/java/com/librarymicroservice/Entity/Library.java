package com.librarymicroservice.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="library")
public class Library {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String address;
	private String email;
	@OneToOne
	@JoinColumn(name = " bookId")
	private Book book;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}

	public Library(Integer id, String name, String address, String email, Book book) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.book = book;
	}
	public Library() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Library [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + "]";
	}
	
	
	
}
