package com.codingdojo.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.repos.TagRepo;

@Service
public class TagService {
	
	@Autowired
	private TagRepo repo;
	
	
	public List<Tag> showAllTags(){
		return repo.findAll();
	};
	
	
	public Tag findTagById(Long id) {
		Optional<Tag> tag = repo.findById(id);
			if(tag.isPresent()) {
				return tag.get();
			} else {
				return null;
			}
		
	};
	
	public void createTag(Tag tag) {
		repo.save(tag);
		return;
		
	};
	
	
	public void delete(Long id) {
		repo.deleteById(id);
	};
}
