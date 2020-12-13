package com.codingdojo.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.repos.NinjaRepo;

@Service
public class NinjaService {

	// @Autowired used to replace the constructor that accepts DojoService as a param, and creates dojoRepo from it.
	// Connects the service with the repo.
	@Autowired
	private NinjaRepo ninjaRepo;
	
	
	// CRUD methods for Ninjas:
	
	// Get all ninjas. 
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	};
	
	
	// Retrieve by ID
	public Ninja findById(Long id) {
		Optional<Ninja> ninja = ninjaRepo.findById(id);
		
		if(ninja.isPresent()) {
			return ninja.get();
		} else {
			return null;
		}
		
	};
	
	
	// Create + Update; Combined into one method; they both perform the same DB operation in Java
	public Ninja save(Ninja ninja) {
		return ninjaRepo.save(ninja);
	};
	
	
	// Delete
	public void delete(Long id) {
		ninjaRepo.deleteById(id);
	};
}

