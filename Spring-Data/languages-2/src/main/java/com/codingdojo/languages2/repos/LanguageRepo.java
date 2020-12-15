package com.codingdojo.languages2.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.languages2.models.Language;


@Repository 
public interface LanguageRepo extends CrudRepository<Language, Long> {
	
	List<Language> findAll();
	

}
