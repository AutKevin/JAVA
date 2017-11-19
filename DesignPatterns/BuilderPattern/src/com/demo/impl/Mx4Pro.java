package com.demo.impl;

import com.demo.abs.CellPhone;

/**
 * Mate7产品类,基本数据类型由继承父类来
 */
public class Mx4Pro extends CellPhone {
	public Mx4Pro() {
		System.out.println("这是华为Mx4Pro手机");
	}
	
	public String toString(){
		return "配置\nCPU:"+this.getCpu()+"\n内存:"+this.getRam()+"\n屏幕大小:"
				+this.getScreen()+"\n电池容量:"+this.getBattery()+"\n外观:"
				+this.getFacade()+"\n其他功能:"+this.getOthers();
	}
}
