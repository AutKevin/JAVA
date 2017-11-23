package com.dynamic.factory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.qy.impl.RealSubject;
import com.qy.inf.Subject;


public class DynamicProxyDemo {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Subject subject = new RealSubject();
		System.out.println(subject.toString()+"执行方法subject.request()结果为");
		subject.request();
		System.out.println("--------------------------------------");
		Subject subjectPro = (Subject) new DynamicProxy(subject).getProxyInstance();
		System.out.println("代理类"+subjectPro.toString()+"执行方法toString()方法也会走代理类");
		System.out.println("--------------");
		subjectPro.request();
		System.out.println("--------------------------------------");
		System.out.println("被代理类"+subject.toString()+"再次执行方法subject.request()结果为");
		subject.request();
	}
}
