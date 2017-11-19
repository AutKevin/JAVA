package com.demo.impl;

import com.demo.abs.CellPhone;
import com.demo.abs.CellPhoneBuilder;
/**
 * Mx4Pro具体建造者(Concrete Builder)
 * 实现抽象建造者方法
 */
public class Mx4ProBuild implements CellPhoneBuilder{
	CellPhone mx4 = new Mx4Pro();
	@Override
	public void buildCPU() {
		mx4.setCpu("三星的CPU");
	}

	@Override
	public void buildRAM() {
		mx4.setRam("3G内存");
	}

	@Override
	public void buildScreen() {
		mx4.setScreen("五点五寸2K高清屏");
	}

	@Override
	public void buildBattery() {
		mx4.setBattery("3300毫安大容量电池");
	}

	@Override
	public void buildFacade() {
		mx4.setFacade("土豪金");
	}

	@Override
	public void buildOthers() {
		mx4.setOthers("360度指纹识别");
	}

	@Override
	public CellPhone getPhone() {
		return mx4;
	}
}
