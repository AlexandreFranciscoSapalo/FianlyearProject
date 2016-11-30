package com.eventSystem.services.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventSystem.domain.Address;
import com.eventSystem.domain.Event;
import com.eventSystem.services.EventService;
import com.eventSystem.services.repositories.EventRepository;

@Service
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;

    @Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    @Override
    public List<?> listAll() {
        List<Event> events = new ArrayList<>();
        try {
			eventRepository.findAll().forEach(events::add); //fun with Java 8
			return events;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }


    @Override
    public Optional<Event> getById(Integer id) {
        return Optional.ofNullable(eventRepository.findOne(id));
    }
    
    @Override
    public Event saveOrUpdate(Event domainObject) {

        try {
			return eventRepository.save(domainObject);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }

    @Override
    public void delete(Integer id) {
        try {
			Event event = eventRepository.findOne(id);
			eventRepository.delete(event);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

   
	public Event SaveOrUpdateEvent(String id, String name, String eventType, String eventTopic) {
		
		Event e = new Event();
        e.setName(name);
        //e.setEventType(eventType);
       // e.setEventTopic(eventTopic);
//        u.setUserToken(RandomStringUtils.randomAlphanumeric(30)+username);
//        switch (role) {
//			case "attendee":  u.setRole(Role.ATTENDEE); break;
//			case "ATTENDEE":  u.setRole(Role.ATTENDEE); break;
//			case "admin":  u.setRole(Role.ADMIN); break;
//			case "ADMIN":  u.setRole(Role.ADMIN); break;
//			case "organizer":  u.setRole(Role.ORGANIZER); break;
//			case "ORGANIZER":  u.setRole(Role.ORGANIZER); break;
//			default:  u.setRole(Role.ATTENDEE); break;
//        }
//        u.setUsername(username);
        
        try {
			return saveOrUpdate(e);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}


	@Override
	public Event SaveOrUpdateEvent(String id, String name, String eventType, String eventTopic, String startDate,
			String StartTime, String endTime, String isOpen, String isFree, String cost, String availableSpaces,
			String speakers, String eventDescription, String addressLine1, String addressLine2, String postCode,
			String city) {
		// TODO Auto-generated method stub
		
		Event e = new Event();
		Address venueAddress = new Address();
		
		if (!id.equals("")){
        		e.setId(Integer.parseInt(id));
        }
	
		e.setName(name);
		e.setEventType(eventType);
		e.setEventTopic(eventTopic);
		e.setStartDate(startDate);
		e.setStartTime(StartTime);
		e.setEndTime(endTime);
		e.setIsOpen(isOpen);
		e.setIsFree(isFree);
		e.setCost(cost);
		e.setAvailableSpaces(availableSpaces);
		e.setSpeakers(speakers);
		e.setEventDescription(eventDescription);
		venueAddress.setAddressLine1(addressLine1);
		venueAddress.setAddressLine2(addressLine2);
		venueAddress.setCity(city);
		venueAddress.setPostCode(postCode);
		e.setVenueAddress(venueAddress);
		
		
		 try {
				return saveOrUpdate(e);
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}

	}
	

	
	
	
	
	
	
	
	
	
	
	
}
