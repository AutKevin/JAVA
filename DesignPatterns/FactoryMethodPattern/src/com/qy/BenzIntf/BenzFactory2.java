package com.qy.BenzIntf;

/**
 * 第二种方法写工厂模式
 * 生产所有实现Benz类接口的子类对象
 */
public interface BenzFactory2 {
	public <T extends Benz> T createFactory(Class<T> T);
}
