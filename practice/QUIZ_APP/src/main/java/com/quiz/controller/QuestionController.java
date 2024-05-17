package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.model.Question;
import com.quiz.service.QuestionService;

@RestController
@RequestMapping(value="/question")
public class QuestionController {
    
    @Autowired
    private QuestionService questionService;
   
    @GetMapping(value="/allQuestions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }
    
    @PostMapping(value="/saveQuestion")
    public Question saveQuestion(@RequestBody Question question) {
        return questionService.saveQuestion(question);
    }
    
    @GetMapping(value="/category/{category}")
    public List<Question> getQuestionByCategory(@PathVariable String category) {
    	return questionService.getQuestionByCategory(category);
    }
    
    @DeleteMapping(value="/delete/{id}")
    public String deleteQuestion(@PathVariable int id) {
    	return questionService.deleteQuestion(id);
    }
    
    
    @PatchMapping(value="/put/{id}")
    public String updateQuestion(@PathVariable int id, @RequestBody Question question) {
    	return questionService.updateQuestion(id,question);
    	
    }
}
