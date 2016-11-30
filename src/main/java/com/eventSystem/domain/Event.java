package com.eventSystem.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Event  extends AbstractDomainClass{
	
	@Column(nullable = false)
	String name;
	
	private String eventType;
			
	private String eventTopic;
	
	@Column(nullable = false)
	private String startDate;
	 
	
	@Column(nullable = false)
	private String startTime;
	
	@Column(nullable = false)
	private String endTime;
	
	 
	@Column(nullable = false)
	private String isOpen;
	
	@Column(nullable = false)
	private String isFree;
	
	private String cost;
	
	private String availableSpaces;
	
	private String speakers;
	
	private String eventDescription;
	
	
	@Embedded
    private Address venueAddress = new Address();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEventTopic() {
		return eventTopic;
	}

	public void setEventTopic(String eventTopic) {
		this.eventTopic = eventTopic;
	}

	public String getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}

	public String getIsFree() {
		return isFree;
	}

	public void setIsFree(String isFree) {
		this.isFree = isFree;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getAvailableSpaces() {
		return availableSpaces;
	}

	public void setAvailableSpaces(String availableSpaces) {
		this.availableSpaces = availableSpaces;
	}

	public String getSpeakers() {
		return speakers;
	}

	public void setSpeakers(String speakers) {
		this.speakers = speakers;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}


	public Address getVenueAddress() {
		return venueAddress;
	}

	public void setVenueAddress(Address venueAddress) {
		this.venueAddress = venueAddress;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	

}
