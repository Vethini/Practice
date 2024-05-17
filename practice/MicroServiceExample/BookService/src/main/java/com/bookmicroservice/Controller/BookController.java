package com.bookmicroservice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmicroservice.Entity.Book;
import com.bookmicroservice.Service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/{id}")
	public Book getBook(@PathVariable int id) {
		return bookService.getBookById(id);
	}
	
	@PostMapping("")
	public Book insertBook(@RequestBody Book book) {
		return bookService.insertBook(book);
	}
}
