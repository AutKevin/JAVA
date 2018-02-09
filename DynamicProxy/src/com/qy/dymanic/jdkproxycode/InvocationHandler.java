package com.qy.dymanic.jdkproxycode;

import java.lang.reflect.Method;

/**
 * 模拟jdk中的InvocationHandler接口
 */
public interface InvocationHandler {

	public void invoke(Object o, Method m);
}
