package com.eventSystem.services;

import java.util.Optional;

import com.eventSystem.domain.Event;
import com.eventSystem.domain.User;

public interface RestConsumerService {

	public Optional<User> getByUsername(String username );
	public Optional<User> saveUser(User user );
	public Event SaveOrUpdateEvent(Event event);

}
