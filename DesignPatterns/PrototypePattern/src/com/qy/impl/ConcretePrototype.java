package com.qy.impl;

import com.qy.inf.Prototype;

/**
 * 具体原型工厂类
 * 
 */
public class ConcretePrototype implements Prototype {
	@Override
	public Prototype clone() {
		try {
			return (Prototype)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
}
