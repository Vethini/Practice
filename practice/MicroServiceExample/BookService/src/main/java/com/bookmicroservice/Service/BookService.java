package com.bookmicroservice.Service;

import org.springframework.stereotype.Service;

import com.bookmicroservice.Entity.Book;
import com.bookmicroservice.Repository.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	public Book getBookById(int id) {
		return bookRepo.findById(id).get();
	}
	
	public Book insertBook(Book book) {
		return bookRepo.save(book);
	}
}
