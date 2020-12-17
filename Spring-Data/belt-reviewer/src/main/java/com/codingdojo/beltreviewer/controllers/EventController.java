package com.codingdojo.beltreviewer.controllers;


import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.beltreviewer.models.Event;
import com.codingdojo.beltreviewer.models.Message;
import com.codingdojo.beltreviewer.models.User;
import com.codingdojo.beltreviewer.services.EventService;
import com.codingdojo.beltreviewer.services.MessageService;
import com.codingdojo.beltreviewer.services.UserService;
import com.codingdojo.beltreviewer.validators.UserValidator;

@Controller
public class EventController {

	@Autowired
	private EventService eventService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private UserValidator userValidator;
	
	
	String[] states = {
			"AL", "AK", "AZ", "AR", "CA", "CO",
	    	"CT", "DE", "FL", "GA", "HI", "ID",
	    	"IL", "IN", "IA", "KS", "KY", "LA",
	    	"ME", "MD", "MA", "MI", "MN", "MS",
	    	"MO", "MT", "NE", "NW", "NH", "NJ",
	    	"NM", "NY", "NC", "ND", "OH", "OK",
	    	"OR", "PA", "RI", "SC", "SD", "TN",
	    	"TX", "UT", "VT", "VA", "WA", "WV",
	    	"WI", "WY" }; 
	
	
	// Register & Login combined to 1 view.
    @GetMapping("/welcome")
    public String showWelcomePage(
    		@ModelAttribute("user") User user, 
    		Model model, 
    		HttpSession session) {
			model.addAttribute("states", states);
			return "log-reg.jsp";
	};
    
    

	// *** User Controller methods ***

  
  @PostMapping(value="/register")
  public String registerUser(
  		Model model,
  		@Valid @ModelAttribute("user") User user,
  		BindingResult result, 
  		HttpSession session) {
      
  	userValidator.validate(user, result);
      
  	if(result.hasErrors()) {
  		model.addAttribute("states", states);
          return "log-reg.jsp";
      }
  	
  	// Register user to DB & set user in session.
      User u = userService.registerUser(user);
      session.setAttribute("userId", u.getId());
      return "redirect:/events";
  }


 
  @PostMapping(value="/login")
  public String loginUser(
  		@RequestParam("email") String email, 
  		@RequestParam("password") String password,
  		@ModelAttribute("user") User user,
  		HttpSession session,
  		RedirectAttributes flashMessage) {
	  
      // If the user is authenticated, save their user id in session
  	if(userService.authenticateUser(email, password)) {
  		User thisUser = userService.findUserByEmail(email);
  		session.setAttribute("userId", thisUser.getId());
  		return "redirect:/events";
  	} else {
  		// Else, add error messages and return the login page.
  		//Debug Notes: besure to spell error or errors correct to match the form c:out ${error} or c:out${errors} 
  		flashMessage.addFlashAttribute("errors", "Failed to login.");
  		return "redirect:/welcome";
  	}
      
  }
	
	
	// GET Event Dashboard
	@RequestMapping("/events")
	public String eventDashboard(@ModelAttribute("event") Event event, Model model,  HttpSession session) {
		Long id = (Long) session.getAttribute("userId");

		if(id != null) {
			User user = userService.findUserById((Long) session.getAttribute("userId"));
			model.addAttribute("user", user);
			model.addAttribute("eventsInState", eventService.findEventByState(user.getState()));
			model.addAttribute("eventsNotInState", eventService.findByStateNot(user.getState()));
			model.addAttribute("states", states);
			return "dashboard.jsp";
		} else {
			return "redirect:/welcome";
		}
		
	};
	
	
	// POST New Event to DB
	@PostMapping("/events")
	public String createNewEvent(HttpSession session, Model model, @Valid @ModelAttribute("event") Event event, BindingResult result) {

		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findUserById(userId);
		
		if(result.hasErrors()) {
			model.addAttribute("user", user);
			model.addAttribute("eventsInState", eventService.findEventByState(user.getState()));
			model.addAttribute("eventsNotInState", eventService.findByStateNot(user.getState()));
			model.addAttribute("states", states);
			return "dashboard.jsp";
		}else {
			event.setHost(user);
			eventService.save(event);
			return "redirect:/events";
		}
	};
	
	@GetMapping("/events/{id}")
	public String eventPage(@PathVariable("id") Long eventId,@ModelAttribute("newMessage") Message message, HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId != null) {
			User user = userService.findUserById((Long) session.getAttribute("userId"));
			Event event = eventService.findById(eventId);
			model.addAttribute("event", event);
			return "showEvent.jsp";
		}else {
			return "redirect:/welcome";
		}
	}
	
	
	
	@GetMapping("/events/{id}/edit")
	public String showEditEventPage(@PathVariable("id") Long eventId,Model model, HttpSession session, @ModelAttribute("event") Event editEvent) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId != null) {
			Event event = eventService.findById(eventId);
			model.addAttribute("date", event.getDateString());
			model.addAttribute("event", event);
			model.addAttribute("states", states);
			return "editEvent.jsp";
		}else {
			return "redirect:/welcome";
		}
	}
	
	@PostMapping("/events/{id}/edit")
	public String editEvent(@PathVariable("id") Long eventId, Model model, HttpSession session, @Valid @ModelAttribute("event") Event editEvent, BindingResult result) {
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findUserById(userId);
		Event event = eventService.findById(eventId);
		if(result.hasErrors()) {
			model.addAttribute("date", event.getDateString());
			model.addAttribute("event", event);
			model.addAttribute("states", states);
			return "editEvent.jsp";
		}else {
			event.setDate(editEvent.getDate());
			event.setName(editEvent.getName());
			event.setLocation(editEvent.getLocation());
			event.setState(editEvent.getState());
			eventService.save(event);
			return "redirect:/events";
		}
	}
	
	@RequestMapping("/events/{id}/delete")
	public String deleteEvent(@PathVariable("id") Long eventId, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId != null) {
			Event event = eventService.findById(eventId);
			Long uid = (Long) session.getAttribute("userId");
			//only delete event if logged in user is the host
			if(uid == event.getHost().getId()) {
				eventService.deleteEvent(event);
			}
			return "redirect:/events";
		}else {
			return "redirect:/welcome";
		}
	}
	
	
	//////////
	//JOIN AND CANCEL JOIN EVENTS.
	//////////
	
	
	@RequestMapping("/events/{id}/join")
	public String joinEvent(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		
		if(userId != null) {
			User user = userService.findUserById((Long) session.getAttribute("userId"));
			Event event = eventService.findById(id);
			event.addAttendee(user);
			eventService.save(event);
			return "redirect:/events";
		} else {
			return "redirect:/welcome";
		}
	}
	
	@RequestMapping("/events/{id}/cancel")
	public String joineEventCancel(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId != null) {
			User user = userService.findUserById((Long) session.getAttribute("userId"));
			Event event = eventService.findById(id);
			event.removeAttendee(user);
			eventService.save(event);
			return "redirect:/events";
		}else {
			return "redirect:/welcome";
		}
	}
	
	

	// *** Messages Controller methods ***
	
	@PostMapping("/events/{id}/message")
	public String addMessage(@PathVariable("id") Long eventId, @RequestParam("newMessage") String message, HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId != null) {
			User user = userService.findUserById((Long) session.getAttribute("userId"));
			Event event = eventService.findById(eventId);
			//create new message
			Message newMessage = new Message();
			newMessage.setMessage(message);
			newMessage.setEvent(event);
			newMessage.setUser(user);
			messageService.createMsg(newMessage);
			return "redirect:/events/"+event.getId();
		}else {
			return "redirect:/welcome";
		}
	}
    

	// *** LOGOUT ***

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
    	session.invalidate();
        // redirect to login page
    	return "redirect:/welcome";
    }
}
