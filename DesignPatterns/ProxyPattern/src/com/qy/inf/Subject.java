package com.qy.inf;

/**
 * 主题角色 
 * 真实和代理的共同接口,可以在任何使用真实主题的地方使用代理主题.
 */
public interface Subject {
	//定义一个请求方法
	public void request();
}
