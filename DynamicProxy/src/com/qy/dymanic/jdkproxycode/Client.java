package com.qy.dymanic.jdkproxycode;

public class Client {

	/**
	 * 模拟jdk动态代理源码
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Car car = new Car();
		InvocationHandler h = new TimeHandler(car);
		Moveable m = (Moveable)Proxy.newProxyInstance(Moveable.class,h);
		m.move();
	}

}
