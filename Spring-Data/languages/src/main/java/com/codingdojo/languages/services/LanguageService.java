package com.codingdojo.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	// Create an instance of the LanguageRepository class.
	private final LanguageRepository languageRepository;
	
	
	// Pass the LanguageRepo instance as a param to the LanguageService constructor; this connects repository + service. 
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	// langueRepository now has access to the CRUDRepository's methods.
	 public List<Language> allLanguages() {
	        return languageRepository.findAll();
	    }
	    // Creates 
	 public Language createLanguage(Language language) {
	        return languageRepository.save(language);
	    }
	    // Retrieves 
	 public Language findLanguage(Long id) {
	     Optional<Language> optionalLanguage = languageRepository.findById(id);
	        if(optionalLanguage.isPresent()) {
	            return optionalLanguage.get();
	        } else {
	            return null;
	        }
	    }
	 	// Update
	public Language updateLanguage(Language language) {
		return languageRepository.save(language);
	}
		// Delete
		public void deleteLanguage(Long id) {
			Optional<Language> optionalLanguage = languageRepository.findById(id);
			if (optionalLanguage.isPresent()) {
				Language target = optionalLanguage.get();
				System.out.println(target.getName() + " has been deleted.");
				languageRepository.deleteById(id);
			}
		}
	

	

	

	
}