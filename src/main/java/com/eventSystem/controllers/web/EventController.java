package com.eventSystem.controllers.web;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eventSystem.comands.EventCreateAndUpdateCommand;
import com.eventSystem.domain.Event;
import com.eventSystem.services.RestConsumerService;
import com.eventSystem.validators.EventCreateAndUpdateValidator;

/**
 * Created by 
 */

@Controller
@PreAuthorize("hasAuthority('ROLE_ORGANIZER')")
@RequestMapping("organizer")
public class EventController {
	
	private RestConsumerService restImp;
	public static Logger log = Logger.getLogger(EventController.class.getName());

    
    private Converter<EventCreateAndUpdateCommand, Event> eventCreateAndUpdateConverter;

    private Validator ecv;
    
    @Autowired
    @Qualifier("eventCreateAndUpdateToEvent")
    public void setConverter(Converter <EventCreateAndUpdateCommand, Event> eventCreateAndUpdateConverter) {
        this.eventCreateAndUpdateConverter = eventCreateAndUpdateConverter;
    }	
    
    @Autowired
    @Qualifier("restConsumerV1")
    public void setRestConsumerService(RestConsumerService restImp) {
        this.restImp = restImp;
    }
    
    @Autowired
    @Qualifier("eventCreateAndUpdateValidator")
    public void setValidator(Validator ecv) {
        this.ecv = ecv;
    }
    
    @RequestMapping("home")
    public String organizerHome(Model model){
    	
    	return "organizer/home";
    	
        
    }
    
    @RequestMapping("add-event")
    public String addEvent(Model model){
    	
    	model.addAttribute("eventCreateAndUpdateCommand", new EventCreateAndUpdateCommand());
    	return "organizer/newEvent";
    	
        
    }
    
    @InitBinder ("eventCreateAndUpdateCommand")
    public void binder(WebDataBinder binder) {
        binder.addValidators(ecv);
    }
    
    @RequestMapping(value="add-event", method = RequestMethod.POST)
    public String addEvent(@Valid EventCreateAndUpdateCommand eventCreateAndUpdateCommand, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
        	return "organizer/newEvent";
        }
        
        System.out.println(restImp.SaveOrUpdateEvent(this.eventCreateAndUpdateConverter.convert(eventCreateAndUpdateCommand)));
        
        return "redirect:/organizer/home";
    }
    
   
    
}
