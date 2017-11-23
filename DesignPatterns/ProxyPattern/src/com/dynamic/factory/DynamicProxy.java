package com.dynamic.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.qy.impl.RealSubject;

/**
 * 创建动态代理对象
 * 动态代理不需要实现接口,但是需要指定接口类型
 */
public class DynamicProxy {
	private Object target;
	public DynamicProxy(Object target) {
		this.target = target;
	}
	
	public Object getProxyInstance() {
		return Proxy.newProxyInstance(RealSubject.class.getClassLoader(), RealSubject.class.getInterfaces(), 
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						beforeRequest();
						Object returnValue = method.invoke(target, args);  //目标对象方法
						afterRequest();
						return returnValue;
					}
				});
	}
	
	//请求前的操作
	public void beforeRequest(){
		//预处理
		System.out.println(target.getClass()+"被动态代理了,在它执行之前要执行动态代理加入的预处理方法");
	}
	//请求后的操作
	public void afterRequest(){
		//善后处理
		System.out.println(target.getClass()+"被动态代理了,在它执行之后要执行动态代理加入的善后方法");
	}
}
