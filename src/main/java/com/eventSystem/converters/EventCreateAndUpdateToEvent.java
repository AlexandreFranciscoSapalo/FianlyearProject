package com.eventSystem.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.eventSystem.comands.EventCreateAndUpdateCommand;
import com.eventSystem.domain.Address;
import com.eventSystem.domain.Event;

@Component("eventCreateAndUpdateToEvent")
public class EventCreateAndUpdateToEvent implements Converter<EventCreateAndUpdateCommand, Event> {
    @Override
    public Event convert(EventCreateAndUpdateCommand evC) {
        Event e = new Event();
        Address venueAddress = new Address();
        
        if (evC.getId() != null) {
        	if (!evC.getId().equals(""))
        		e.setId(Integer.parseInt(evC.getId()));
        }
		e.setName(evC.getName());
		e.setEventTopic(evC.getTopic());
		e.setEventType(evC.getType());
		e.setStartDate(evC.getDate());
		e.setStartTime(evC.getStartTimeHour()+":"+evC.getStartTimeMinute()+" "+evC.getStartTimeMeridiem());
		e.setEndTime(evC.getEndTimeHour()+":"+evC.getEndTimeMinute()+" "+evC.getEndTimeMeridiem());
		e.setIsOpen(evC.getIsOpen());
		e.setIsFree(evC.getIsFree());
		e.setCost(evC.getCost());
		e.setAvailableSpaces(evC.getAvailableSpaces());
		e.setSpeakers(evC.getSpeakers());
		e.setEventDescription(evC.getEventDescription());
		venueAddress.setAddressLine1(evC.getAddressLine1());
		venueAddress.setAddressLine2(evC.getAddressLine2());
		venueAddress.setCity(evC.getCity());
		venueAddress.setPostCode(evC.getPostCode());
		e.setVenueAddress(venueAddress);
        return e;
    }


}
