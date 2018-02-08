package com.dynamic.car;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Demo {

	public static void main(String[] args) {
		Car car = new Car();
		Class<?> clazz = car.getClass();
		//日志代理
		InvocationHandler logHandler = new LogInvocationHandler(car);
	    Moveable mv = (Moveable)Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), logHandler);
	    //用时代理
		InvocationHandler timeHandler = new TimeInvocationHandler(mv);
	    Moveable mv2 = (Moveable)Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), timeHandler);
	    //运行run方法
	    mv2.run();
	}

}
