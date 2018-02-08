package com.dynamic.car;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理后的处理方法-日志记录
 */
public class LogInvocationHandler implements InvocationHandler {
	private Object object;
	public LogInvocationHandler(Object object) {
		this.object = object;
	}
	/* 
	 * 日志代理
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("日志开始记录"+method.getName());
		method.invoke(object, args);
		System.out.println("日志记录完毕");
		return null;
	}
}
