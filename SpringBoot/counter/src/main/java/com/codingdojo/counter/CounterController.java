package com.codingdojo.counter;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CounterController {
	
	 
	@RequestMapping("/")
	public String index(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		if(count == null) {
			count = 1;
		}else {
			count++;
		}
		session.setAttribute("count", count);
		return "index.jsp";
	}
	
	
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		if(count == null) {
			count = 0;
			session.setAttribute("count", count);
		}
		return "counter.jsp";
	}
	
	
	@RequestMapping("/counter2")
	public String counter2 (HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		if(count == null) {
			count = 2;
		}else {
			count+=2;
		}
		session.setAttribute("count", count);
		return "counter.jsp";
	}
	
	
	@RequestMapping("/reset")
	public String reset (HttpSession session) {
		Integer count = 0;
		session.setAttribute("count", count);
		return "index.jsp";
	}

	
}
