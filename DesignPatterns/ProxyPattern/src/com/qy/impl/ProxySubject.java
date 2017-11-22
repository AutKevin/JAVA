package com.qy.impl;

import com.qy.inf.Subject;

/**
 * 代理主题角色
 * 在需要的时候创建或删除真实对象,并且在真实主题角色处理完毕前后做预处理和善后处理工作.
 */
public class ProxySubject implements Subject{
	private Subject subject;
	
	//实例化的时候把需要代理的对象传进来
	public ProxySubject(Subject subject) {
		this.subject = subject;
	}

	//代理后的方法执行内容
	@Override
	public void request() {
		this.beforeRequest();
		subject.request();
		this.afterRequest();
	}
	
	//请求前的操作
	public void beforeRequest(){
		//预处理
		System.out.println(subject.getClass()+"被代理了,在它执行之前要执行预处理方法");
	}
	//请求后的操作
	public void afterRequest(){
		//善后处理
		System.out.println(subject.getClass()+"被代理了,在它执行之后要执行善后方法");
	}
}
