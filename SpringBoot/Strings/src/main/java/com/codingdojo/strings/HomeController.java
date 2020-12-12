package com.codingdojo.strings;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/hello")

public class HomeController {
	
	@RequestMapping("/test")
	public String inex(Model model){
		
		model.addAttribute("dojoName", "Orange County");
		return "index.jsp";
	}
	
}
