package com.qy.AbstractFactoryI;

/**
 * 抽象工厂-创建多个产品而不是单独的一个
 * 为创建一组相关或相互依赖的对象提供一个接口，而且无需指定他们的具体类。
 */
public interface IFactory {
	public IBook createBook();
	public IGame createGame();
	public IProduct createProduct();
}
