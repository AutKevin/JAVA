package com.demo.abs;
/**
 * 抽象建造者(Builder)
 * 规范手机的各个组成部分,具体如何组成由具体实现类决定
 */
public interface CellPhoneBuilder {
	public void buildCPU();
	public void buildRAM();
	public void buildScreen();
	public void buildBattery();
	public void buildFacade();
	public void buildOthers();
	public CellPhone getPhone();
}
