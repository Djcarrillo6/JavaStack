package com.codingdojo.dojooverflow.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.services.AnswerService;
import com.codingdojo.dojooverflow.services.QuestionService;
import com.codingdojo.dojooverflow.services.TagService;

@Controller 
public class MainController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private TagService tagService;
	
	@Autowired
	private AnswerService answerService;
	
	
	
	// Routes
	
	// Display ALL questions on Question Dashboard
	@GetMapping("/questions")
	public String allQuestions(Model model) {
		model.addAttribute("questions", questionService.showAllQuestions());
		model.addAttribute("tags", tagService.showAllTags());
		return "index.jsp";
	};
	
	
	@GetMapping("/questions/new")
	public String questionForm(ModelMap map) {
		
		Question question = new Question();
		Tag tag = new Tag();
		
		map.addAttribute("question", question);
		map.addAttribute("tag", tag);
		
		return "new-question-form.jsp";
	};
	
	@PostMapping("/submit-question")
	public String createQuestion(@Valid @ModelAttribute("question") Question question, BindingResult resultQ, Tag tag, BindingResult resultT) {
			if(resultQ.hasErrors() || resultT.hasErrors()) {
				return "new-question-form.jsp";
			}
			
			questionService.save(question);
			tagService.createTag(tag);
			return "redirect:/questions";
	};

}
