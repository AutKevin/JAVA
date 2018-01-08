package com.qy.impl;

import com.qy.inf.Abstraction;
import com.qy.inf.Implementor;

/**
 * 修正抽象化角色
 */
public class RefinedAbstraction extends Abstraction {

	public RefinedAbstraction(Implementor imp) {
		super(imp);
	}
	//修改父类的方法
	public void operation(){
		super.operation();
		System.out.println("修正抽象化角色");
	}
}
