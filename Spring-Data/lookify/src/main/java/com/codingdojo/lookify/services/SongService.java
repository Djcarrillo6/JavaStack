package com.codingdojo.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.repos.SongRepo;


@Service
public class SongService {

	// @Autowired to connect Service to Repository
	@Autowired
	private SongRepo songRepo;
	
	
	// *** CRUD Methods ***
	
	
	// Get all songs from DB
	public List<Song> allSongs() {
		return songRepo.findAll();
	};
	
	
	// Retrieve
	public Song findSong(Long id) {
		Optional<Song> song = songRepo.findById(id);
		
		if(song.isPresent()) {
			return song.get();
		} else {
			return null;
		}
	};
	
	
	// Create + Update; Combined to one method, and ALWAYS sent via HTTP "POST"
	public Song save(Song song) {
		return songRepo.save(song);
	};
	
	
	// Delete
	public void deleteSong(Long id) {
		Optional<Song> optionalSong = songRepo.findById(id);
		if (optionalSong.isPresent()) {
			Song target = optionalSong.get();
			System.out.println(target.getTitle() + " has been deleted.");
			songRepo.deleteById(id);
		}
	};
	
	public List<Song> findAllByRatings(){
		return songRepo.findTop10ByOrderByRatingDesc();
	};
	
	public List<Song> findArtist(String searchString){
		return songRepo.findByArtistContaining(searchString);
	};
	
}
