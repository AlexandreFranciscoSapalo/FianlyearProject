package com.eventSystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eventSystem.domain.Role;
import com.eventSystem.domain.User;
import com.eventSystem.services.RestConsumerService;

@Component
public class Bootstrap {

	private RestConsumerService restImp;


    @Autowired
    public void setRestConsumerService(RestConsumerService restImp) {
        this.restImp = restImp;
    }
    
    public void start(){
    	addUser();
    }
    
    public void addUser(){
    	User u = new User();
    	u.setUsername("afs18");
    	u.setEmail("afs18@gmail.com");
    	u.setPassword("afs187");
    	u.setRole(Role.ATTENDEE);
    	
    	this.restImp.saveUser(u);
    	
    	u = new User();
    	u.setUsername("afs187");
    	u.setEmail("afs18@gmail.com");
    	u.setPassword("afs187");
    	u.setRole(Role.ORGANIZER);
    	
    	this.restImp.saveUser(u);
    	
    }
	
}
