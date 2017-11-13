package com.qy.impl;

import com.qy.intf.Product;

/**
 * 具体产品角色接口
 */
public class ConcreteProduct implements Product {

	@Override
	public void method1() {
		System.out.println("this is methodone by class"+this.getClass().getName());
	}

	@Override
	public void method2() {
		System.out.println("this is methodtwo by class"+this.getClass().getName());
	}

}
