package com.qy.inf;

import com.qy.impl.Decorator;

/**
 * 具体修饰
 */
public class ConcreteDecorator extends Decorator {
	public ConcreteDecorator(Component component) {
		super(component);
	}
	
	//装饰类添加的方法
	private void addmethod(){
		System.out.println("Decorator添加的方法");
	}
	//重写operation方法
	public void operation(){
		this.addmethod();
		super.operation();
	}
}
