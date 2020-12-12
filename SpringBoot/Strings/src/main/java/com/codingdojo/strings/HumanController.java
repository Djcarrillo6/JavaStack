package com.codingdojo.strings;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class HumanController {

	
	@RequestMapping("/")
	public String home(@RequestParam(value="name", required=false) String name, @RequestParam(value="lastName", required=false) String lastName) {
		String output;
		if(name == null) {
			output = "<h1>Hello Human!</h1><p>Welcome to SpringBoot!</p>";
		}else if(lastName == null) {
			output = "<h1>Hello " + name + "!</h1><p>Welcome to SpringBoot!</p>";
		}else {
			output = "<h1>Hello " + name + " " + lastName + "!</h1><p>Welcome to SpringBoot!</p>";
		}
		return output;
	}
}
