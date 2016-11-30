package com.eventSystem.controllers.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eventSystem.domain.Event;
import com.eventSystem.services.EventService;

@RestController
@RequestMapping("API/event")
public class EventAPIController {

	private EventService eventService;
	
	private String apiToken_ = "secret";
	private final String apiTokentHeaderString = "API-TOKEN";
	private final String userTokentHeaderString = "USER-TOKEN";


    @Autowired
    public void setUserService(EventService eventService) {
    	
        this.eventService = eventService;
        
    }

   

    @RequestMapping(value="/add-event", method = RequestMethod.POST)
    public Event saveOrUpdate(
    		@RequestHeader(apiTokentHeaderString) String apiToken,
    		@RequestParam("id") String id,
    		@RequestParam("name") String name,
    		@RequestParam("eventType") String eventType,
    		@RequestParam("eventTopic") String eventTopic,
    		@RequestParam("startDate") String startDate,
    		@RequestParam("startTime") String StartTime,
    		@RequestParam("endTime") String endTime,
    		@RequestParam("isOpen") String isOpen,
    		@RequestParam("isFree") String isFree,
    		@RequestParam("cost") String cost,
    		@RequestParam("availableSpaces") String availableSpaces,
    		@RequestParam("speakers") String speakers,
    		@RequestParam("eventDescription") String eventDescription,
    		@RequestParam("addressLine1") String addressLine1,
    		@RequestParam("addressLine2") String addressLine2,
    		@RequestParam("postCode") String postCode,
    		@RequestParam("city") String city
		)
    {
    	
    	if (apiToken.equals(this.apiToken_)) {
    		return eventService.SaveOrUpdateEvent(id, name, eventType, eventTopic, startDate, 
    				StartTime, endTime, isOpen, isFree, cost, availableSpaces, speakers, eventDescription, 
    				addressLine1, addressLine2, postCode, city);
    	}
    	
    	return null;
        
    }
    

}
