package com.qy.impl;

import com.qy.inf.Component;
/**
 * 装饰类角色
 * 抽象类
 */
public abstract class Decorator implements Component {
	private Component component = null;
	public Decorator(Component component) {
		this.component = component;
	}

	@Override
	public void operation() {
		this.component.operation();
	}
}
