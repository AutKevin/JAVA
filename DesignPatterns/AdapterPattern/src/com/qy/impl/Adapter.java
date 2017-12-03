package com.qy.impl;
import com.qy.inf.Target;

/**
 * 适配器 
 * --要继承目标角色和源角色
 */
public class Adapter extends Adaptee implements Target {
	@Override
	public void request() {
		System.out.println("适配器改良开始");
		super.specificRequest();
		System.out.println("适配器改良结束");
	}
}
