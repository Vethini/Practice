package com.librarymicroservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarymicroservice.Entity.Library;

public interface LibraryRepository extends JpaRepository<Library,Integer>{

}
