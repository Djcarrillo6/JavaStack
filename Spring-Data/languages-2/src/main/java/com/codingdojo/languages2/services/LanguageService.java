package com.codingdojo.languages2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.languages2.models.Language;
import com.codingdojo.languages2.repos.LanguageRepo;



@Service 
public class LanguageService {

	@Autowired
	private LanguageRepo languageRepo;
	
	
	// CRUD Method
	
	// Get All Languages in DB
	public List<Language> allLanguages(){
		return languageRepo.findAll();
	};
	
	
	
	// Retrieve
	public Language findById(Long id) {
		Optional<Language> language = languageRepo.findById(id);
		
			if(language.isPresent()) {
				return language.get();
			} else {
				return null;
			}
	};
	
	
	
	// Create + Update Combined
	public Language save(Language language) {
		return (Language) languageRepo.save(language);
	}
	
	
	
	// Delete from DB
	public void deleteLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepo.findById(id);
		if (optionalLanguage.isPresent()) {
			languageRepo.deleteById(id);
		}
	};
	
	
}
