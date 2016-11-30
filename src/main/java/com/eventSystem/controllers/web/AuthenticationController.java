package com.eventSystem.controllers.web;

import java.security.Principal;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eventSystem.comands.LoginCommand;
import com.eventSystem.services.RestConsumerService;

/**
 * Created by 
 */

@Controller
public class AuthenticationController {
	
	private RestConsumerService restImp;
	public static Logger log = Logger.getLogger(AuthenticationController.class.getName());

 
    
    @Autowired
    public void setRestConsumerService(RestConsumerService restImp) {
        this.restImp = restImp;
    }
   

    @RequestMapping("/login_success")
    public String index(Model model){
    	

    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	IndexController.log.info(auth.getAuthorities());
    	if (auth.getAuthorities().toString().equals("[ROLE_ORGANIZER]")) {
    		return "redirect:/organizer/home";  	
    	}
        
    	return "redirect:/";  
    }

    @RequestMapping("login")
    public String loginForm(Model model){
    	
    	model.addAttribute("loginCommand", new LoginCommand());
        return "login";
    }
    
    @RequestMapping("/login_error")
    public String loginError(Model model, @Valid LoginCommand loginCommand, BindingResult bindingResult){
    	
    	model.addAttribute("error","error");
        return "index";
    }
    
    
}
