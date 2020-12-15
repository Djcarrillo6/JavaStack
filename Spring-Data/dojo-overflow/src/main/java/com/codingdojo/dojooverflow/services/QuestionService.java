package com.codingdojo.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.repos.QuestionRepo;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepo repo;
	
	
	public List<Question> showAllQuestions(){
		return repo.findAll();
	};
	
	
	public Question findQuestionById(Long id) {
		Optional<Question> question = repo.findById(id);
			if(question.isPresent()) {
				return question.get();
			} else {
				return null;
			}
		
	};
	
	public void save(Question question) {
		repo.save(question);
		return;
		
	};
	
	
	public void delete(Long id) {
		repo.deleteById(id);
	};
	
}
