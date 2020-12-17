package com.codingdojo.beltreviewer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.beltreviewer.models.Event;
import com.codingdojo.beltreviewer.repos.EventRepository;

@Service 
public class EventService {
	
	@Autowired
	private EventRepository eventRepo;
	
	
	
	// CRUD Methods wrapped in Service methods that are called by controller.
	
	// GET all Events
	public List<Event> allEvents(){
		return eventRepo.findAll();
	};
	
	
	
	// Retrieve event by ID
	public Event findById(Long id) {
		Optional<Event> event = eventRepo.findById(id);
		
			if(event.isPresent()) {
				return event.get();
			} else {
				return null;
			}
	};
	
	
	// Create & Update event combined.
	public Event save(Event event) {
		return eventRepo.save(event);
	};
	
	
	// Delete event
	public void deleteEvent(Event event) {
		eventRepo.delete(event);
	}
	
	// Service methods for state-table renders
	public List<Event> findEventByState(String state){
		return eventRepo.findByState(state);
	}
	
	public List<Event> findByStateNot(String state){
		return eventRepo.findByStateNot(state);
	}

}
