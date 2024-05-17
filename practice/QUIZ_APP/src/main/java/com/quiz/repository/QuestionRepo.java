package com.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quiz.model.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {
	
	List<Question> findByCategory(String category);
	
	@Query(value ="SELECT * FROM question q WHERE q.category=:category ORDER BY RAND() LIMIT :noofQuestions",nativeQuery=true)
	List<Question> findRandomQuestionsByCategory(String category, int noofQuestions);
	//List<Question> findRandomQuestionsByCategory(String category, int noofQuestions);
}
