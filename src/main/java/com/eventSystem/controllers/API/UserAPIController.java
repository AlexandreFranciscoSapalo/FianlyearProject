package com.eventSystem.controllers.API;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eventSystem.controllers.web.IndexController;
import com.eventSystem.domain.Role;
import com.eventSystem.domain.User;
import com.eventSystem.services.UserService;
import com.eventSystem.services.security.EncryptionService;

@RestController
@RequestMapping("API/user")
public class UserAPIController {

	private UserService userService;
	
	private String apiToken_ = "secret";
	private EncryptionService encryptionService;
	private final String apiTokentHeaderString = "API-TOKEN";
	private final String userTokentHeaderString = "USER-TOKEN";

	@Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @Autowired
    public void setUserService(UserService userService) {
    	
        this.userService = userService;
        
    }

    @RequestMapping({"/list"})
    public List<User> listUsersByRole(
	    		@RequestHeader(apiTokentHeaderString) String apiToken,
	    		@RequestHeader(userTokentHeaderString) String userToken,
	    		@RequestParam("role") String role,
	    		@RequestParam("page") int page
    		)
    {
    	if (apiToken.equals(this.apiToken_)) {
    	
	    	try {
				switch (role) {
					case "attendee": return userService.findByRole(Role.ATTENDEE, page);
					case "admin": return userService.findByRole(Role.ADMIN, page);
					case "organizer": return userService.findByRole(Role.ORGANIZER, page);
					default: return null;
				}
			} catch (Exception e) {
				e.printStackTrace();
				
			}
    	}
    	
    	return null;
    	
    }
//
//    @RequestMapping("/show/{id}")
//    public String getUser(@PathVariable Integer id, Model model){
//        model.addAttribute("user", userService.getById(id));
//        return "user/show";
//    }
//
//    @RequestMapping("/edit/{id}")
//    public String edit(@PathVariable Integer id, Model model){
//        model.addAttribute("user", userService.getById(id));
//        return "user/userform";
//    }

    @RequestMapping(value="/new", method = RequestMethod.POST)
    public User newUser(
    		@RequestHeader(apiTokentHeaderString) String apiToken,
    		@RequestParam("email") String email,
    		@RequestParam("username") String username,
    		@RequestParam("password") String password,
    		@RequestParam("role") String role
		)
    {
    	
    	if (apiToken.equals(this.apiToken_)) {
    		return userService.createNewUser(email, username, password, role);
    	}
    	
    	return null;
        
    }
    
    @RequestMapping(value="/authenticate", method = RequestMethod.POST)
    public String authenticate(
    		@RequestHeader(apiTokentHeaderString) String apiToken,
    		@RequestParam("username") String username,
    		@RequestParam("password") String password
		)
    {
    	
    	if (apiToken.equals(this.apiToken_)) {
    		Optional<User> u = userService.findByUserName(username);
    		if (u.isPresent()) {
    			if (this.encryptionService.checkPassword(password, u.get().getPasswordHash())){
    				return u.get().getUserToken();
    			}
    			else {
    				return "error";
    			}
    			
    		}
    		else {
    			
    		}
    	}
    	
    	return "error";
        
    }
    
    @RequestMapping(value= "/get/by-token", produces={"application/json"})
    public User getUserByUserToken(
	    		@RequestHeader(apiTokentHeaderString) String apiToken,
	    		@RequestHeader(userTokentHeaderString) String userToken
    		)
    {
    	
    	if (apiToken.equals(this.apiToken_)) {
    		
    		Optional<User> u = userService.findByUserToken(userToken);
    		if (u.isPresent()) {
    			return u.get();
    		}
    	}
    	
    	return null;
    	

    	
    }
    
    @RequestMapping(value= "/get/by-username", produces={"application/json"})
    public User getUserByUsername(
	    		@RequestHeader(apiTokentHeaderString) String apiToken,
	    		@RequestParam("username") String username
    		)
    {
    	
    	if (apiToken.equals(this.apiToken_)) {
    		IndexController.log.info("entered get by username");
    		Optional<User> u = userService.findByUserName(username);
    		if (u.isPresent()) {
    			return u.get();
    		}
    	}
    	
    	IndexController.log.info("not present");
    	return null;
    	

    	
    }

//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public String saveOrUpdate(User user){
//        User savedUser = userService.saveOrUpdate(user);
//        return "redirect:/user/show/" + savedUser.getId();
//    }
//
//    @RequestMapping("/delete/{id}")
//    public String delete(@PathVariable Integer id){
//        userService.delete(id);
//        return "redirect:/user/list";
//    }
}
