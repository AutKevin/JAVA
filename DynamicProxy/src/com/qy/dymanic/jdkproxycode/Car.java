package com.qy.dymanic.jdkproxycode;

import java.util.Random;

/**
 * 车类接口具体实现类
 */
public class Car implements Moveable {
	
	@Override
	public void move() {
		try {
			Thread.sleep(new Random().nextInt(3*1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("car is running...");
	}
}
