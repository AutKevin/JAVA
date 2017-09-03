package com.qy.listener;

public class Demo {

	public static void main(String[] args) {
        Person person = new Person(new PersonListener() {
			
			@Override
			public void doRun(Event event) {
				System.out.println(event.person+"跑步监控中...");
			}
			
			@Override
			public void doEat(Event event) {
				System.out.println(event.person+"跑步监控中");
			}
		});
        person.doEat();
        person.doRun();
	}

}
