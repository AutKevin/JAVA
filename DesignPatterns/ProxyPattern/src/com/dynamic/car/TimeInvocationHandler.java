package com.dynamic.car;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理之后的处理方法-处理时间记录
 */
public class TimeInvocationHandler implements InvocationHandler {
	private Object object;
	public TimeInvocationHandler(Object object) {
		this.object = object;
	}
	/* 
	 * 用时代理
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("开始计算时间");
		long startTime = System.currentTimeMillis();
		method.invoke(object, args);
		long endTime = System.currentTimeMillis();
		System.out.println("计算时间完毕,共用时"+(endTime-startTime)+"毫秒");
		return null;
	}

}
