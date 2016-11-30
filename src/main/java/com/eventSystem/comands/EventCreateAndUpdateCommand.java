package com.eventSystem.comands;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class EventCreateAndUpdateCommand {

    private String id = "";
	
	@NotEmpty
	@Size(min = 2, max = 250)
    private String name = "";
	
	@NotEmpty
	@Size(min = 2, max = 75)
    private String type = "";
	
	@NotEmpty
	@Size(min = 2, max = 75)
    private String topic = "";
	
	@NotEmpty
	@Size(min = 5, max = 10)
    private String date = "";
	
    private String startTimeHour = "";
	
    private String startTimeMinute = "";
	
    private String startTimeMeridiem = "";
	
    private String endTimeHour = "";

    private String endTimeMinute = "";
	
    private String endTimeMeridiem = "";
	
	@NotEmpty
	@Size(min = 5, max = 15)
    private String isOpen = "";
	
	@NotEmpty
	@Size(min = 3, max = 3)
    private String isFree = "";
	
    private String cost = "";
    
    private String availableSpaces;
    
    private String Speakers;
	
	private String eventDescription;
	
	@NotEmpty
	@Size(min = 1, max = 250)
	private String addressLine1;
	
	@Size(min = 0, max = 250)
	private String addressLine2;
	
    @NotEmpty
	@Size(min = 2, max = 50)
    private String city;
    
    @NotEmpty
	@Size(min = 3, max = 10)
    private String postCode;

    
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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
		return Speakers;
	}

	public void setSpeakers(String speakers) {
		Speakers = speakers;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	
	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getStartTimeHour() {
		return startTimeHour;
	}

	public void setStartTimeHour(String startTimeHour) {
		this.startTimeHour = startTimeHour;
	}

	public String getStartTimeMinute() {
		return startTimeMinute;
	}

	public void setStartTimeMinute(String startTimeMinute) {
		this.startTimeMinute = startTimeMinute;
	}

	public String getEndTimeMeridiem() {
		return endTimeMeridiem;
	}

	public void setEndTimeMeridiem(String endTimeMeridiem) {
		this.endTimeMeridiem = endTimeMeridiem;
	}

	public String getEndTimeHour() {
		return endTimeHour;
	}

	public void setEndTimeHour(String endTimeHour) {
		this.endTimeHour = endTimeHour;
	}

	public String getEndTimeMinute() {
		return endTimeMinute;
	}

	public void setEndTimeMinute(String endTimeMinute) {
		this.endTimeMinute = endTimeMinute;
	}

	public String getStartTimeMeridiem() {
		return startTimeMeridiem;
	}

	public void setStartTimeMeridiem(String startTimeMeridiem) {
		this.startTimeMeridiem = startTimeMeridiem;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

}