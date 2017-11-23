package com.Cglib;

public class CglibDemo {
	public static void main(String[] args) {
		RealSubject target = new RealSubject();
		RealSubject proxy = (RealSubject) new ProxyFactory(target).getProxyInstance();
		proxy.request();
	}
}
