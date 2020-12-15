package com.codingdojo.languages2.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.languages2.models.Language;
import com.codingdojo.languages2.services.LanguageService;

@Controller
public class MainController {

	@Autowired
	private LanguageService languageService;
	
	
	
	// Routes
	
	// GET All Languages
	@RequestMapping("/languages")
	public String index(@ModelAttribute("language") Language language, Model model) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	
	// New Language form
	@GetMapping("/languages/new")
	public String form(@ModelAttribute("language") Language language) {
		return "new.jsp";
	};
	
	
	// POST form to add Langauge to DB
	@PostMapping("/languages")
	public String createNewLanguage(@Valid @ModelAttribute("language") Language language, 
																BindingResult result) {
			if(result.hasErrors()) {
				return "new.jsp";
			}
		
		languageService.save(language);
		return "redirect:/languages";
	};
	
	
	// GET request to show Langauge details
	@GetMapping("/languages/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findById(id);
		model.addAttribute("language", language);
		return "show.jsp";
	};
	
	
	
	// Update/Edit Language form GET request
	@GetMapping("/languages/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findById(id);
		model.addAttribute("language", language);
		return "edit.jsp";
	};
	
	
	// POST to Update a Language
	@RequestMapping(value="/languages/{id}", method=RequestMethod.POST)
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
			if(result.hasErrors()) {
				return "edit.jsp";
			} else {
				languageService.save(language);
				return "redirect:/languages";
			}
	};
	
	
	@RequestMapping(value="/languages/{id}/delete", method=RequestMethod.POST)
	public String destroy(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
}
