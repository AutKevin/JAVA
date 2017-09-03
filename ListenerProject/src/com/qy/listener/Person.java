package com.qy.listener;
//事件源
public class Person {
	PersonListener personListener=null;
    public void doEat() {
		System.out.println("吃饭中...");
		personListener.doEat(new Event(this));
	}
    public void doRun(){
    	System.out.println("跑步中...");
    	personListener.doRun(new Event(this));
    }
    
	public Person(PersonListener personListener) {
		this.personListener = personListener;
	}
    
}
