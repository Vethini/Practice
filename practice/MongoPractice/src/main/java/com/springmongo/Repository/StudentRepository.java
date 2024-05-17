package com.springmongo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springmongo.Model.Student;

public interface StudentRepository extends MongoRepository<Student,String> {

}
