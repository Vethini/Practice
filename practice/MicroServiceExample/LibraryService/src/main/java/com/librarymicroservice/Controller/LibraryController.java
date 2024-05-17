package com.librarymicroservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.librarymicroservice.Entity.Library;
import com.librarymicroservice.Service.LibraryService;
import com.librarymicroservice.Entity.*;

@RestController
@RequestMapping("/library")
public class LibraryController {

	
	private final LibraryService libraryService;
	
	public LibraryController(LibraryService libraryService) {
		this.libraryService = libraryService;
	}
	
	@Autowired
	private  RestTemplate restTemplate;
	

	@GetMapping("{id}")
	public Library getLibraryById(@PathVariable int id) {
		
		Book book = restTemplate.getForObject("http://localhost:9001/book/"+id,Book.class);
		
		Library library =  libraryService.getLibraryById(id);
		library.setBook(book);
		return library;
	}
	
	@PostMapping("")
	public Library insertLibrary(@RequestBody Library library) {
		return libraryService.insertLibrary(library);
	}
}
