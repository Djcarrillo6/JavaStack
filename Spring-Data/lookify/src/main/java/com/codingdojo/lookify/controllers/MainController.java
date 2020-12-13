package com.codingdojo.lookify.controllers;

import java.util.List;

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

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;


@Controller 
public class MainController {
	
	@Autowired
	private SongService songService;
	
	

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	};
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("songs", songService.allSongs());
		return "dashboard.jsp";
	};
	
	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song, BindingResult result) {
		return "new.jsp";
	};
	
	@RequestMapping("/search/topTen")
	public String topTenPage(Model model) {
		List<Song> songs = songService.findAllByRatings();
		model.addAttribute("songs", songs);
		return "top-songs.jsp";
	}
	
	@RequestMapping("/lookify/search/{searchString}")
	public String searchPage(@PathVariable("searchString") String search, Model model) {
		List<Song> songs = songService.findArtist(search);
		model.addAttribute("songs", songs);
		model.addAttribute("query", search);
		return "search-results.jsp";
	}
	
	
	@PostMapping(value="/addSong")
	public String addSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
			if(result.hasErrors()) {
				return "new.jsp";
			}
			System.out.println("New song POST route entered!");
		
		songService.save(song);
		return "redirect:/dashboard";
	};
	
	
	@PostMapping(value="/songs/{id}")
	public String delete(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/";
	};
	
	@RequestMapping(value="/song/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		
		return "show.jsp";
	}
	
	
}
