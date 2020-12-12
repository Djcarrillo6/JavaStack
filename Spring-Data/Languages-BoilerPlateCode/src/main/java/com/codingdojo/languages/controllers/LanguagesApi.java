package com.codingdojo.languages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;


	@RestController
	public class LanguagesApi {
	private final LanguageService languageService;
		
		public LanguagesApi(LanguageService languageService) {
			this.languageService = languageService;
		}
		@RequestMapping("/api/languages")
		public List<Language> index() {
		    return languageService.allLanguages();
		}
		    
		@PostMapping(value="/api/languages")
		   public Language create(
				   @RequestParam(value="name") String name, 
				   @RequestParam(value="creator") String creator, 
				   @RequestParam(value="version") String version) {
			Language language = new Language(name, creator, version);
			return languageService.createLanguage(language);		
	}
		
		    
		@RequestMapping("/api/languages/{id}")
		public Language show(@PathVariable("id") Long id) {
		    Language language = languageService.findLanguage(id);
		    return language;
		}
		
		@PutMapping(value="/api/languages/{id}")
		public Language update(
				@PathVariable("id") Long id, 
				@RequestParam(value="name") String name, 
				@RequestParam(value="creator") String creator, 
				@RequestParam(value="version") String version) {
			Language l = languageService.findLanguage(id);
			l.setName(name);
			l.setCreator(creator);
			l.setVersion(version);
			languageService.updateLanguage(l);
		    return l;
		 }

		
		 @DeleteMapping(value="/api/languages/{id}")
		 public void destroy(@PathVariable("id") Long id) {
		    languageService.deleteLanguage(id);
		 }
	}


