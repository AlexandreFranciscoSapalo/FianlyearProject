package com.eventSystem.controllers.web;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eventSystem.comands.LoginCommand;
import com.eventSystem.domain.User;
import com.eventSystem.services.RestConsumerService;

/**
 * Created by 
 */

@Controller
public class IndexController {
	
	private RestConsumerService restImp;
	public static Logger log = Logger.getLogger(IndexController.class.getName());

    @Autowired
    public void setRestConsumerService(RestConsumerService restImp) {
        this.restImp = restImp;
    }

    @RequestMapping({"/", ""})
    public String index(Model model){
    	log.info("Enter index controller");
    	model.addAttribute("user", restImp.getByUsername("afs18").orElse(null));
    	model.addAttribute("loginCommand", new LoginCommand());
    	log.info(restImp.getByUsername("afs18").orElse(null));
        return "index";
    }

    @RequestMapping("/access_denied")
    public String notAuth(){
        return "access_denied";
    }

}
