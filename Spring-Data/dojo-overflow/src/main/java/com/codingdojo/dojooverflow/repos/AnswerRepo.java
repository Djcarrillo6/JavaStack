package com.codingdojo.dojooverflow.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojooverflow.models.Answer;

@Repository 
public interface AnswerRepo extends CrudRepository<Answer, Long> {
	List<Answer> findAll();
}
