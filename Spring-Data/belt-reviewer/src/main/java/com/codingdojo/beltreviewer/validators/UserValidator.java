package com.codingdojo.beltreviewer.validators;



import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.codingdojo.beltreviewer.models.User;
import com.codingdojo.beltreviewer.services.UserService;

@Component
public class UserValidator implements Validator{

	private final UserService userService;
	
	public UserValidator(UserService userService) {
		this.userService = userService;
	}

	
    // 1
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    
    // 2
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            // 3
            errors.rejectValue("passwordConfirmation", "Match");
        }
		User foundUser = userService.findUserByEmail(user.getEmail());
		if(foundUser != null) {
			errors.rejectValue("email", "Match");
		}
    }
}
