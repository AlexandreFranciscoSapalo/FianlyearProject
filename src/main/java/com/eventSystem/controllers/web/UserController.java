package com.eventSystem.controllers.web;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eventSystem.comands.UserCreateCommand;
import com.eventSystem.domain.User;
import com.eventSystem.services.RestConsumerService;
import com.eventSystem.validators.UserCreateValidator;

/**
 * Created by 
 */

@Controller
public class UserController {
	
	private RestConsumerService restImp;
	public static Logger log = Logger.getLogger(UserController.class.getName());

    
    private Converter<UserCreateCommand, User> userCreateToUserConverter;

    private UserCreateValidator ucv;
    
    @Autowired
    @Qualifier("userCreateToUser")
    public void setUserUserDetailsConverter(Converter <UserCreateCommand, User> userCreateToUserConverter) {
        this.userCreateToUserConverter = userCreateToUserConverter;
    }	
    
    @Autowired
    public void setRestConsumerService(RestConsumerService restImp) {
        this.restImp = restImp;
    }
    
    @Autowired
    public void setUserCreateValidator(UserCreateValidator ucv) {
        this.ucv = ucv;
    }
    
    
    @RequestMapping("create-account")
    public String createAccount(Model model){
    	
    	model.addAttribute("userCreateCommand", new UserCreateCommand());
        return "register";
    }
    
    
    @InitBinder ("userCreateCommand")
    public void binder(WebDataBinder binder) {
        binder.addValidators(ucv);
    }
    
    @RequestMapping(value="create-account", method = RequestMethod.POST)
    public String createAccountSave(@Valid UserCreateCommand userCreateCommand, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
        	return "register";
        }
        
        restImp.saveUser(this.userCreateToUserConverter.convert(userCreateCommand));
        
        return "redirect:/";
    }
    
}
