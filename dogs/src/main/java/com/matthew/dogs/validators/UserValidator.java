package com.matthew.dogs.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.matthew.dogs.models.User;
import com.matthew.dogs.repositories.UserRepository;

@Component
public class UserValidator {
	@Autowired
	private UserRepository uRepo;
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		if(!user.getPassword().equals(user.getConfirmPassword())){
			errors.rejectValue("password", "Match", "Hey you, Passwords Do Not Match!");
		}
		
		// Make sure email is unique in the database
		if(this.uRepo.existsByEmail(user.getEmail())) {
			errors.rejectValue("email", "Unique", "Email has already been registered there, person!");
		}
		
		if(user.getFirstName().equals("Matt")){
			errors.rejectValue("firstName", "noMattsAllowed", "Sorry , we're not accepting Matt's at this time.");
		}
	}
}
