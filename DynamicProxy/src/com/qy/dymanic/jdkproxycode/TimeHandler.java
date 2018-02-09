package com.qy.dymanic.jdkproxycode;

import java.lang.reflect.Method;

/**
 * 代理实例的处理方法
 * 在原本的实例基础上进行增加功能
 * 接口也可以无子类,直接通过接口方法名调用代理的invoke方法
 */
public class TimeHandler implements InvocationHandler {

	private Object target;
	
	public TimeHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public void invoke(Object o, Method m) {
		try {
			long starttime = System.currentTimeMillis();
			System.out.println("开始计时....");
			m.invoke(target);
			long endtime = System.currentTimeMillis();
			System.out.println("计时结束,用时"
							+ (endtime - starttime) + "毫秒");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
