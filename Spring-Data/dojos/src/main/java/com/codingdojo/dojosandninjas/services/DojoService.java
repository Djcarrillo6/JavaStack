package com.codingdojo.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.repos.DojoRepo;

@Service
public class DojoService {

	// @Autowired used to replace the constructor that accepts DojoService as a param, and creates dojoRepo from it.
	// Connects the service with the repo.
	@Autowired
	private DojoRepo dojoRepo;
	
	
	// CRUD methods for Dojos
	
	// Get all dojos. 
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	};
	
	
	// Retrieve
	public Dojo findById(Long id) {
		Optional<Dojo> dojo = dojoRepo.findById(id);
		
		if(dojo.isPresent()) {
			return dojo.get();
		} else {
			return null;
		}
		
	};
	
	
	// Create + Update; Combined into one method; they both perform the same DB operation in Java
	public Dojo save(Dojo dojo) {
		return dojoRepo.save(dojo);
	};
	
	
	// Delete
	public void delete(Long id) {
		dojoRepo.deleteById(id);
	};
}
