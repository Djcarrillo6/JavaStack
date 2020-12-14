package com.codingdojo.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.repos.AnswerRepo;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepo repo;
	
	
	public List<Answer> showAllAnswers(){
		return repo.findAll();
	};
	
	
	public Answer findAnswerById(Long id) {
		Optional<Answer> answer = repo.findById(id);
			if(answer.isPresent()) {
				return answer.get();
			} else {
				return null;
			}
		
	};
	
	public void createAnswer(Answer answer) {
		repo.save(answer);
		return;
		
	};
	
	
	public void delete(Long id) {
		repo.deleteById(id);
	};
	
	
}
