package com.bookmicroservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmicroservice.Entity.Book;

public interface BookRepository extends JpaRepository<Book,Integer>{

}
