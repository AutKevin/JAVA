package com.demo.abs;

/**
 * 抽象产品类
 * 共同的数据类型,继承用
 */
public abstract class CellPhone {
	private String cpu;    //CPU型号
	private String ram;    //内存
	private String screen;    //屏幕
	private String battery;    //电池
	private String facade;    //外观
	private String others;    //其他部件
	
	/**
	 * @return the cpu
	 */
	public String getCpu() {
		return cpu;
	}
	/**
	 * @param cpu the cpu to set
	 */
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	/**
	 * @return the ram
	 */
	public String getRam() {
		return ram;
	}
	/**
	 * @param ram the ram to set
	 */
	public void setRam(String ram) {
		this.ram = ram;
	}
	/**
	 * @return the screen
	 */
	public String getScreen() {
		return screen;
	}
	/**
	 * @param screen the screen to set
	 */
	public void setScreen(String screen) {
		this.screen = screen;
	}
	/**
	 * @return the battery
	 */
	public String getBattery() {
		return battery;
	}
	/**
	 * @param battery the battery to set
	 */
	public void setBattery(String battery) {
		this.battery = battery;
	}
	/**
	 * @return the facade
	 */
	public String getFacade() {
		return facade;
	}
	/**
	 * @param facade the facade to set
	 */
	public void setFacade(String facade) {
		this.facade = facade;
	}
	/**
	 * @return the others
	 */
	public String getOthers() {
		return others;
	}
	/**
	 * @param others the others to set
	 */
	public void setOthers(String others) {
		this.others = others;
	}
	
	
}
