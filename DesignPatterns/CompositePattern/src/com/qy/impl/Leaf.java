package com.qy.impl;

import com.qy.inf.Component;

/**
 * 叶子构件 
 */
public class Leaf implements Component {
	@Override
	public void operation() {
		//省略业务逻辑代码
		System.out.println(this.toString()+"叶子构建业务");
	}
}
