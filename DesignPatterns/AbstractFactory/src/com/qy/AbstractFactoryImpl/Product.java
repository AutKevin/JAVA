package com.qy.AbstractFactoryImpl;

import com.qy.AbstractFactoryI.IProduct;

public class Product implements IProduct {

	String company = "";
	String produceName = "";
	public Product(String company,String produceName) {
		this.company = company;
		this.produceName = produceName;
	}
	@Override
	public void method1() {
		System.out.print("我们是"+company+"公司,我们的卖产品是"+produceName);
		System.out.println("this is Product method1 by " + this.getClass().getName());
	}

	@Override
	public void method2() {
		System.out.print("我们是"+company+"公司,我们的卖产品是"+produceName);
		System.out.println("this is Product method2 by "+this.getClass().getName());
	}

}
