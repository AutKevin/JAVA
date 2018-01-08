package com.facade.demo;

import com.subsys.demo.Airport;
import com.subsys.demo.Chauffeur;
import com.subsys.demo.Hotel;

//秘书-相当于外观模式类
public class Secretary {
	private Chauffeur chauffeur = new Chauffeur();
	private Hotel hotel = new Hotel();
	private Airport airport = new Airport();
	//安排出差
	public void travel(String to,int days){
		airport.bookTicket("扬州", to);
		chauffeur.drive("泰州机场");
		hotel.bookRook(days);
	}
}
