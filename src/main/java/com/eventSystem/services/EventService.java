package com.eventSystem.services;

import com.eventSystem.domain.Event;

public interface EventService extends CRUDService<Event> {

	Event SaveOrUpdateEvent(String id, String name, String eventType, String eventTopic, String startDate, 
			String StartTime, String endTime, String isOpen, String isFree, String cost, String availableSpaces, String speakers, String eventDescription, 
			String addressLine1, String addressLine2, String postCode, String city);
}
