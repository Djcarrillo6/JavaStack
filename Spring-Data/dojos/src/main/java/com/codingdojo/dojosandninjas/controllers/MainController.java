package com.codingdojo.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.services.DojoService;
import com.codingdojo.dojosandninjas.services.NinjaService;

@Controller
public class MainController {

	
		// Gives the controller access to both services via their instances and inherited methods. 
		@Autowired 
		private DojoService dojoService;
		
		@Autowired
		private NinjaService ninjaService;
		
		
		// Routes
		
		// Get All Dojo's route.
		@GetMapping("/")
		public String allDojos(Model model) {
			model.addAttribute("dojos",  dojoService.allDojos());
			return "index.jsp";
		};
		
		
		// GET New Dojo form
		@GetMapping("/createDojo")
		public String createDojo(@ModelAttribute("dojo") Dojo dojo) {
			return "NewDojo.jsp";
		};
		
		
		/// POST new dojo to DB
		@PostMapping("/createDojo")
		public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
			if(result.hasErrors()) {
				return "NewDojo.jsp";
			} 
			
			dojoService.save(dojo);
			return "redirect:/";
		}
		
		
		// GET create Ninja form
		@GetMapping("/createNinja")
		public String createNinjaForm(@ModelAttribute("ninja") Ninja ninja, Model model) {
			model.addAttribute("dojos", dojoService.allDojos());	
			return "NewNinja.jsp";
		};
		
		
		// POST to create a Ninja
		@PostMapping("/createNinja")
		public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
			if(result.hasErrors()) {
				return "NewNinja.jsp";
			}
			
			// By saving the ninja, we also save the associated Dojo from the form.
			ninjaService.save(ninja);
			return "redirect:/";
		}
}
