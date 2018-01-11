package com.qy.impl;

import java.util.HashMap;
import java.util.Map;

import com.qy.inf.Flyweight;

/**
 * 享元工厂类 
 **/
public class FlyweightFactory {
	private static Map<String, Flyweight> pool = new HashMap<String, Flyweight>();
	private FlyweightFactory(){};    //私有构造方法
	public static Flyweight getFlyweight(String intrinsicState){
		Flyweight flyweight = pool.get(intrinsicState);
		if (flyweight == null) {
			flyweight = new ConcreteFlyweight(intrinsicState);
			pool.put(intrinsicState, flyweight);
		}
		return flyweight;
	}
}
