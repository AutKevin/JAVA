package com.qy.impl;

import com.qy.inf.Implementor;

/**
 * 具体实现化角色 
 */
public class ConcreteImplementor implements Implementor {
	//方法的实现化实现
	@Override
	public void operationImpl() {
		System.out.println("具体实现化角色");
	}

}
