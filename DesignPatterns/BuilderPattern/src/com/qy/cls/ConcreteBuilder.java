package com.qy.cls;

import com.qy.abs.Builder;

/**
 * 具体建造者(Concrete Builder)
 * 实现建造者中定义的方法,并且返回一个组建好的产品实例.
 */
public class ConcreteBuilder extends Builder {
	private Product product = new Product();
	//设置产品零件
	@Override
	public void setPart1() {
		//为product产品安装部件1
	}
	@Override
	public void setPart2() {
		//为product产品安装部件2
	}
	@Override
	public void setPart3() {
		//为product产品安装部件3
	}
	//...其他部件
	//建造一个产品
	@Override
	public Product builderProduct() {
		return product;
	}
}
