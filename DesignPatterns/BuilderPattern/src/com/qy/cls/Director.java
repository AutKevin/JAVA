package com.qy.cls;

import com.qy.abs.Builder;

/**
 * 导演者角色(Director)
 * 负责调用具体建造者的方法,告诉Builder开始建造
 */
public class Director {
	private Builder builder = new ConcreteBuilder();
	//构造产品,负责调用各个零件构造方法
	public Product build(){
		builder.setPart1();
		builder.setPart2();
		builder.setPart3();
		//...其他部件
		return builder.builderProduct();
	}
}
