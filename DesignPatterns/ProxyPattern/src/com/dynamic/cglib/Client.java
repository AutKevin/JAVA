package com.dynamic.cglib;

public class Client {

	/**
	 * 测试
	 */
	public static void main(String[] args) {
		CglibProxy proxy = new CglibProxy();
		Train t = (Train)proxy.getProxy(Train.class);
		t.move();
	}

}
