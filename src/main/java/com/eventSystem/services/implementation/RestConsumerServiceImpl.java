package com.eventSystem.services.implementation;

import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.eventSystem.domain.Event;
import com.eventSystem.domain.User;
import com.eventSystem.services.RestConsumerService;

@Service("restConsumerV1")
public class RestConsumerServiceImpl implements RestConsumerService{
	
	
	private RestTemplate rt = new RestTemplate();
	private final String baseUrl = "http://localhost:8000";
	private final String apiToken = "secret";
	private final String apiTokentHeaderString = "API-TOKEN";
	private final String userTokentHeaderString = "USER-TOKEN";
	
	public void authenticateUSer(String username, String password ) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.set(apiTokentHeaderString, apiToken);

		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("username", username);
		map.add("password", password);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		
		ResponseEntity<User> response = rt.postForEntity(baseUrl+"/get/by-token", request, User.class);
	}
	
	public Optional<User> getByUsername(String username ) {
			
			HttpHeaders headers = new HttpHeaders();
			headers.set(apiTokentHeaderString, apiToken);
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.add("Accept", "application/json");	
			
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.baseUrl+"/API/user/get/by-username")
			        .queryParam("username", username);

			HttpEntity<?> entity = new HttpEntity<>(headers);

			HttpEntity<User> response = rt.exchange(
			        builder.build().encode().toUri(), 
			        HttpMethod.GET, 
			        entity, 
			        User.class);
			
			Optional<User> u;
			if (response.getBody() == null) 		
				u = Optional.empty();
			else 
				u = Optional.of(response.getBody());
			
			return u;
		}
	
	public Optional<User> saveUser(User user ) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.set(apiTokentHeaderString, apiToken);
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Accept", "application/json");	
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.baseUrl+"/API/user/new")
		        .queryParam("email", user.getEmail())
		.queryParam("username", user.getUsername())
		.queryParam("password", user.getPassword())
		.queryParam("role", user.getRole().toString());

		HttpEntity<?> entity = new HttpEntity<>(headers);

		HttpEntity<User> response = rt.exchange(
		        builder.build().encode().toUri(), 
		        HttpMethod.POST, 
		        entity, 
		        User.class);
		
		Optional<User> u;
		if (response.getBody() == null) 		
			u = Optional.empty();
		else 
			u = Optional.of(response.getBody());
		
		return u;
	}

	@Override
	public Event SaveOrUpdateEvent(Event event) {
		// TODO Auto-generated method stub
		
		HttpHeaders headers = new HttpHeaders();
		headers.set(apiTokentHeaderString, apiToken);
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Accept", "application/json");	
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.baseUrl+"/API/event/add-event")
				.queryParam("id", event.getId()) 
				.queryParam("name", event.getName()) 
				.queryParam("eventType", event.getEventType()) 
				.queryParam("eventTopic", event.getEventTopic()) 
				.queryParam("startDate", event.getStartDate()) 
				.queryParam("startTime", event.getStartTime()) 
				.queryParam("endTime", event.getEndTime()) 
				.queryParam("isOpen", event.getIsOpen()) 
				.queryParam("isFree", event.getIsFree()) 
				.queryParam("cost", event.getCost()) 
				.queryParam("availableSpaces", event.getAvailableSpaces()) 
				.queryParam("speakers", event.getSpeakers()) 
				.queryParam("eventDescription", event.getEventDescription()) 
				.queryParam("addressLine1", event.getVenueAddress().getAddressLine1()) 
				.queryParam("addressLine2", event.getVenueAddress().getAddressLine2()) 
				.queryParam("postCode", event.getVenueAddress().getPostCode()) 
				.queryParam("city", event.getVenueAddress().getCity());

		HttpEntity<?> entity = new HttpEntity<>(headers);

		HttpEntity<Event> response = rt.exchange(
		        builder.build().encode().toUri(), 
		        HttpMethod.POST, 
		        entity, 
		        Event.class);
		
		Event e;
		if (response.getBody() == null) 		
			e = null;
		else 
			e = response.getBody();
		
		return e;
	
	}
	
	}
