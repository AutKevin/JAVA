package com.qy.intf;

/**
 * 工厂方法模式
 * 抽象工厂角色接口
 */
public interface Creator {
	
	/**
	 * 创建一个产品对象,输入参数(实现特定接口的)类型可以自行设置 
	 * @param c
	 * @return
	 */
	public <T extends Product>T factory(Class<T> c);    //只能创建实现Product接口的类的对象
}
