package com.codingdojo.beltreviewer.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.beltreviewer.models.User;
import com.codingdojo.beltreviewer.repos.UserRepository;

@Service
public class UserService {
	
	
    @Autowired
    private UserRepository userRepo;
    
    
    // Register User + Hashing
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepo.save(user);
    };
    
    
    // Find user by email
    public User findUserByEmail(String email) {
        return userRepo.findByEmail(email);
    };
    
    
    // Find User by id
    public User findUserById(Long id) {
    	Optional<User> user = userRepo.findById(id);
    	
    	if(user.isPresent()) {
            return user.get();
    	} else {
    	    return null;
    	}
    };
    
    
    // Authenticate User
    public boolean authenticateUser(String email, String password) {
    	
        // Locate User in DB via email
        User user = userRepo.findByEmail(email);
        // If user not located w/email, return false to boolean.
        if(user == null) {
            return false;
        } else {
            // If un-hashed pw === pw in DB return true to boolen; else return false.
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
};