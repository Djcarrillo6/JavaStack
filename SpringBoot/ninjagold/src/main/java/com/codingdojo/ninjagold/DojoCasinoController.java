package com.codingdojo.ninjagold;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;





@Controller
public class DojoCasinoController {

	public ArrayList<Object> activities = new ArrayList<Object>();
	public String color;
	
	


	
	@RequestMapping(value="/")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);	
		}
		
		model.addAttribute("activities", activities);
		
		
		return "index.jsp";
	};
	


	@RequestMapping(value="/", method=RequestMethod.POST)
		public String process_gold( @RequestBody() String postData, HttpSession session ) {
			String location = postData.substring(0, postData.indexOf("="));
			Random random = new Random();
			int n = 0;
			int gold = (int) session.getAttribute("gold");
			String text = "You entered a ";
			String gained = "gained";
			String color = "green";
			String posOrNeg = "";
			
			
			String format = "EEEEE dd yyyy KK:mm aa";
			SimpleDateFormat dateFormat= new SimpleDateFormat(format);
			String timeStamp = dateFormat.format(new Date());


					
			MyString customObj = new MyString(text, color, location, gained, posOrNeg, timeStamp);
			
			switch(location) {
			case "casino":
				n = random.nextInt(50);
				
				if(random.nextInt(2) == 1) {
					n = -n;
					gained = "lost";
					color = "red";
					
					customObj.setLocation(location);
					customObj.setGained(gained);
					customObj.setColor(color);
					customObj.setColor("red");
					customObj.setPosOrNeg("negative");
					customObj.setTimeStamp(timeStamp);
					
				}
				break;
			case "farm":
				n = random.nextInt(10) + 10;
				
				customObj.setLocation(location);
				customObj.setGained(gained);
				customObj.setColor(color);
				customObj.setColor("green");
				customObj.setPosOrNeg("positive");
				customObj.setTimeStamp(timeStamp);
				break;
			case "house":
				n = random.nextInt(3) + 2;
				
				customObj.setLocation(location);
				customObj.setGained(gained);
				customObj.setColor(color);
				customObj.setColor("greeen");
				customObj.setPosOrNeg("positive");
				customObj.setTimeStamp(timeStamp);
				break;
			case "cave":
				n = random.nextInt(5) + 5;
				
				customObj.setLocation(location);
				customObj.setGained(gained);
				customObj.setColor(color);
				customObj.setColor("green");
				customObj.setPosOrNeg("positive");
				customObj.setTimeStamp(timeStamp);
				break;
			}
			// text += location + " and " + gained + "gold " + gold;
			
			// Put finals string result into session, and then render <it class=""></it>
			String finalStringResult = customObj.getLocation() + " and " + customObj.getGained() + "gold" + customObj.getGold();
			gold += n;
			session.setAttribute("gold", gold);
			
			activities.add(customObj);
			
			return "redirect:/";
			
	}
			
	
	
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	
}
