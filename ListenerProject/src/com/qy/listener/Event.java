package com.qy.listener;

//事件对象
public class Event {
	
    Person person=null;

	public Event(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
        
}
