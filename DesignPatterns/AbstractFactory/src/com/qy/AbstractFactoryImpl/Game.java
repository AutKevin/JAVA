package com.qy.AbstractFactoryImpl;

import com.qy.AbstractFactoryI.IGame;

public class Game implements IGame {

	String company = "";
	String gameName = "";
	public Game(String company,String gameName) {
		this.company = company;
		this.gameName = gameName;
	}
	@Override
	public void method1() {
		System.out.print("我们是"+company+"公司,我们做的游戏是"+gameName);
		System.out.println("this is Game method1 by "+this.getClass().getName());
	}

	@Override
	public void method2() {
		System.out.print("我们是"+company+"公司,我们做的游戏是"+gameName);
		System.out.println("this is Game method2 by "+this.getClass().getName());
	}

}
