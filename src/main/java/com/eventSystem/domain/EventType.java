package com.eventSystem.domain;

public enum EventType {
	
	CEREMONIAL ("Ceremonial"),
	CONCERT ("Concert"),
	CONFERENCE ("Conference"),
	WORKSHOP ("Workshop"),
	TD ("Talks & Discussions"),
	FILM ("Film"),
	SEMINAR ("Seminar"), 
	NN ("None Of Above");
	
	
	private String name;

	EventType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    } 
	
}
