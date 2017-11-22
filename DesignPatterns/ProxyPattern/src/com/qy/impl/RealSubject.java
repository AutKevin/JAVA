package com.qy.impl;

import com.qy.inf.Subject;

/**
 * 真实主题角色
 * 被代理角色,是业务逻辑的执行者 
 */
public class RealSubject implements Subject{
	@Override
	public void request() {
		//业务逻辑处理
		System.out.println("真实主题角色处理中...");
	}
}
