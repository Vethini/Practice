package com.quiz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.model.Question;
import com.quiz.repository.QuestionRepo;

@Service
public class QuestionService {
    
    @Autowired
    private QuestionRepo questionRepo;
    
    public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }
    
    public Question saveQuestion(Question question) {
        return questionRepo.save(question);
    }

	public List<Question> getQuestionByCategory(String category) {
		return questionRepo.findByCategory(category);
	}

	public String deleteQuestion(int id) {
		questionRepo.deleteById(id);
		return "Question Deleted Successfully";
	}

	public String updateQuestion(int id, Question question) {
	    Optional<Question> questOptional = questionRepo.findById(id);
	    if (questOptional.isPresent()) {
	        Question existingQuestion = questOptional.get();
	        existingQuestion.setQuestionTitle(question.getQuestionTitle());
	        existingQuestion.setCategory(question.getCategory());
	        existingQuestion.setDifficultyLevel(question.getDifficultyLevel());
	        existingQuestion.setOption1(question.getOption1());
	        existingQuestion.setOption2(question.getOption2());
	        existingQuestion.setOption3(question.getOption3());
	        existingQuestion.setOption4(question.getOption4());
	        existingQuestion.setRightAnswer(question.getRightAnswer());
	        questionRepo.save(existingQuestion);
	        return "Question of id "+id+" is Updated Successfully";
	    } else {
	    	return "Question of id "+id+" is Not Found";
	    }
	}

}
