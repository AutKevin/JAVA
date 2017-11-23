package com.qy.impl;

import com.qy.inf.Component;

/**
 * 具体构建
 * 原始对象类
 */
public class ConcreteComponent implements Component{
	@Override
	public void operation() {
		//业务代码
		System.out.println("原始对象业务代码");
	}
}
