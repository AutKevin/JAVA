package com.dynamic.car;

import java.util.Random;

/**
 * 车类接口实现类
 */
public class Car implements Moveable {
	@Override
	public void run() {
		try {
			Thread.sleep(new Random().nextInt(3*1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("car is running...");
	}
}
