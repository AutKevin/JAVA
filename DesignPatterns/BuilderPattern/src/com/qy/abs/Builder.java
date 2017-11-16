package com.qy.abs;
import com.qy.cls.Product;


/**
 * 抽象建造者角色Builder
 * 规范产品的组成部分
 */
public abstract class Builder {
	//设置产品的部分部分,以获得不同的产品
	public abstract void setPart1();
	public abstract void setPart2();
	public abstract void setPart3();
	//...更多部件限制
	//建造产品
	public abstract Product builderProduct();
}
