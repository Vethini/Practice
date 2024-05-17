package com.librarymicroservice.Service;

import org.springframework.stereotype.Service;

import com.librarymicroservice.Entity.Library;
import com.librarymicroservice.Repository.LibraryRepository;

@Service
public class LibraryService {

	
	private final LibraryRepository libraryRepo;
	
	public LibraryService(LibraryRepository libraryRepo) {
		this.libraryRepo = libraryRepo;
	}
	
	public Library getLibraryById(int id) {
		return libraryRepo.findById(id).get();
	}
	
	public Library insertLibrary(Library library) {
		return libraryRepo.save(library);
	}
}
