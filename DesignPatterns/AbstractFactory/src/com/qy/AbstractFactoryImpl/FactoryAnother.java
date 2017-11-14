package com.qy.AbstractFactoryImpl;

import com.qy.AbstractFactoryI.IBook;
import com.qy.AbstractFactoryI.IFactory;
import com.qy.AbstractFactoryI.IGame;
import com.qy.AbstractFactoryI.IProduct;

/**
 * 另一个具体工厂-生产另一组实例
 * 在工厂内部指定好,而不需要再调用时去指定.
 */
public class FactoryAnother implements IFactory{

	@Override
	public IBook createBook() {
		return new Book("B","系统架构设计师");
	}

	@Override
	public IGame createGame() {
		return new Game("B","LOL");
	}

	@Override
	public IProduct createProduct() {
		return new Product("B","红米");
	}

}
