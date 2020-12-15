package com.codingdojo.dojooverflow.repos;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojooverflow.models.Question;


@Repository
public interface QuestionRepo extends CrudRepository<Question, Long> {

}