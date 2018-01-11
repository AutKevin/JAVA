package com.qy.impl;
import com.qy.inf.Flyweight;

/**
 * 具体享元类
 **/
public class ConcreteFlyweight implements Flyweight {
	private String instrinsicState;    //内部状态
	
	public ConcreteFlyweight(String intrinsicState) {
		this.instrinsicState = intrinsicState;
	}
	
	@Override
	public void operation(String extrinsicState) {
		System.out.println("内部状态:"+instrinsicState+",外部状态:"+extrinsicState);
	}
}
