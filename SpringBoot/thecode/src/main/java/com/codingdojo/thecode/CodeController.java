package com.codingdojo.thecode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {
	
	@RequestMapping("/form")
	public String index() {
		return "index.jsp";
	}
	
	 @RequestMapping("/wrong-code")
	    public String flashMessages(RedirectAttributes redirectAttributes) {
	        redirectAttributes.addFlashAttribute("error", "You must train harder!");
	        return "redirect:/form";
	 }
	
	@RequestMapping(value="/code", method=RequestMethod.POST) 
		public String test(@RequestParam(value="code") String code) {
		String password = "bushido";
			
			if(code.equalsIgnoreCase(password)) return "secretpage.jsp";
			
		return "redirect:/wrong-code";
		} 
}

