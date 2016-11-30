package com.eventSystem.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.eventSystem.comands.UserCreateCommand;
import com.eventSystem.controllers.web.IndexController;
import com.eventSystem.services.RestConsumerService;

@Component
public class UserCreateValidator implements Validator{

	@Autowired
	private RestConsumerService restImp;

  
	@Override
    public boolean supports(Class<?> clazz) {
        return UserCreateCommand.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
       
    	UserCreateCommand u = (UserCreateCommand) target;
      
        if (!u.getPassword().equals(u.getPasswordRepeated())) {
        	
            errors.rejectValue("password", "mustMatch", "Password must match");
            errors.rejectValue("passwordRepeated", "mustMatch", "Password must match");
            
        }

        if (usernameExist(u.getUsername())){
        	 IndexController.log.info(u.getUsername());
        	errors.rejectValue("username", "usernameInUse", "This username is already in use. Enter a different username");
        }
        
        
    }
    
    public boolean usernameExist(String username) {
    	
    	IndexController.log.info("a");
    	if (restImp == null)
    		IndexController.log.info("null");
    	IndexController.log.info(restImp.getByUsername(username));
    	return restImp.getByUsername(username).isPresent();
    }

	
}
