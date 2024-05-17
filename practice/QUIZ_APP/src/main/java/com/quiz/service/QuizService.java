package com.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.model.Question;
import com.quiz.model.QuestionWrapper;
import com.quiz.model.Quiz;
import com.quiz.model.Response;
import com.quiz.repository.QuestionRepo;
import com.quiz.repository.QuizRepo;

@Service
public class QuizService {

	@Autowired
	QuizRepo quizRepo;
	
	@Autowired
	QuestionRepo questionRepo;
	

	public ResponseEntity<String> createQuiz(String category, int noofQuestions, String title) {
		List<Question> questions = questionRepo.findRandomQuestionsByCategory(category,noofQuestions);
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizRepo.save(quiz);
		
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}
	
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id){
		Optional<Quiz> quiz =  quizRepo.findById(id);
		List<Question> questionFromDb = quiz.get().getQuestions();
		List<QuestionWrapper> quewra= new ArrayList();
		for(Question q : questionFromDb) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			quewra.add(qw);
			
		}
		
		return new ResponseEntity<>(quewra,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		Quiz quiz = quizRepo.findById(id).get();
		List<Question> questions = quiz.getQuestions();
		int right = 0;
		int i = 0;
		for(Response response : responses) {
			if(response.getResponse().equals(questions.get(i).getRightAnswer()))
				right++;
		i++;
		}
		return new ResponseEntity<>(right, HttpStatus.OK);
	}
}
