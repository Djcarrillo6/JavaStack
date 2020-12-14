package com.codingdojo.dojooverflow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.codingdojo.dojooverflow.models.Question;
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
		return "index.jsp";
	};
	
	
	@GetMapping("/questions/new")
	public String questionForm(@ModelAttribute("question") Question question) {
		return "new-question-form.jsp";
	};

}
