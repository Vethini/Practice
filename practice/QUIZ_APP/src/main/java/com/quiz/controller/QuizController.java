package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.model.Question;
import com.quiz.model.QuestionWrapper;
import com.quiz.model.Response;
import com.quiz.service.QuizService;

@RestController
@RequestMapping(value="/quiz")
public class QuizController {
	
	@Autowired
	QuizService quizService;
	
	@PostMapping(value="/create")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int noofQuestions, @RequestParam String title){
	return quizService.createQuiz(category,noofQuestions, title);
	}

	@GetMapping(value="/quizQuestions/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id)
	{
		return quizService.getQuizQuestions(id);
		
	}
	
	@PostMapping(value="/submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> response){
		return quizService.calculateResult(id,response);
	}
}
