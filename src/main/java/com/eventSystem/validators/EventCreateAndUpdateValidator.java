package com.eventSystem.validators;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.eventSystem.comands.EventCreateAndUpdateCommand;
import com.eventSystem.services.RestConsumerService;

@Component("eventCreateAndUpdateValidator")
public class EventCreateAndUpdateValidator implements Validator{

	@Autowired
	private RestConsumerService restImp;
	
	private static final String reg =
            "(1[012]|[1-9]):([1-9]|[0-5][0-9])(\\s)?(?i)(AM|PM)";
	
	private Pattern pattern = Pattern.compile(reg);
  
	@Override
    public boolean supports(Class<?> clazz) {
        return EventCreateAndUpdateCommand.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
       
    	EventCreateAndUpdateCommand ev = (EventCreateAndUpdateCommand) target;
     
    	
        	
    		if (ev.getStartTimeMinute().length() < 2) {
    			ev.setStartTimeMinute("0"+ev.getStartTimeMinute());
    		}
    		
    		if (ev.getEndTimeMinute().length() < 2) {
    			ev.setEndTimeMinute("0"+ev.getEndTimeMinute());
    		}
    		
        	
    		if (!pattern.matcher(ev.getStartTimeHour()+":"+ev.getStartTimeMinute()+" "+ev.getStartTimeMeridiem()).matches()) {
    			errors.rejectValue("startTimeHour", "invalidHour", "Invalid hour Format");
    		}
    		if (!pattern.matcher(ev.getEndTimeHour()+":"+ev.getEndTimeMinute()+" "+ev.getEndTimeMeridiem()).matches()) {
    			errors.rejectValue("endTimeHour", "invalidHour", "Invalid hour Format");
    		} 
            
    		System.out.println(ev.getDate());
    		if (!ev.getDate().matches("\\d{4}-\\d{2}-\\d{2}") && !ev.getDate().matches("\\d{4}/\\d{2}/\\d{2}")) {
    			errors.rejectValue("date", "invalidDate", "Invalid date Format. Valid format is YYYY/MM/DD");
    		}
    	
 
        
    }

	
}
