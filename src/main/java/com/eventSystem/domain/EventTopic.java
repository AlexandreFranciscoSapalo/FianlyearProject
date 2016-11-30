package com.eventSystem.domain;

public enum EventTopic {
	
	AC ("Arts & Culture"),
	BE ("Business & Enterprise"),
	ES ("Environment & Sustainability"),
	HW ("Health & Wellbeing"),
	PS ("Science & Technology"),
	ST ("Politics & Society"), 
	NN ("None Of Above");
	
	
	private String name;

	EventTopic(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }   
    
}
