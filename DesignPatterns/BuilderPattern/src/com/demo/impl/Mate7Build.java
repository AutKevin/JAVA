package com.demo.impl;

import com.demo.abs.CellPhone;
import com.demo.abs.CellPhoneBuilder;

/**
 * Mate7具体建造者(Concrete Builder)
 * 实现抽象建造者方法
 */
public class Mate7Build implements CellPhoneBuilder {
	CellPhone mate7 = new Mate7();
	@Override
	public void buildCPU() {
		mate7.setCpu("华为研发的芯片");
	}

	@Override
	public void buildRAM() {
		mate7.setRam("3G内存");
	}

	@Override
	public void buildScreen() {
		mate7.setScreen("六寸高清屏");
	}

	@Override
	public void buildBattery() {
		mate7.setBattery("4100毫安大容量电池");
	}

	@Override
	public void buildFacade() {
		mate7.setFacade("琥珀金");
	}

	@Override
	public void buildOthers() {
		mate7.setOthers("后背指纹识别");
	}

	@Override
	public CellPhone getPhone() {
		return mate7;
	}

}
