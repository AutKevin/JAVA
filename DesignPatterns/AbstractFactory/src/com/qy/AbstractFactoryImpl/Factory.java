package com.qy.AbstractFactoryImpl;

import com.qy.AbstractFactoryI.IBook;
import com.qy.AbstractFactoryI.IFactory;
import com.qy.AbstractFactoryI.IGame;
import com.qy.AbstractFactoryI.IProduct;

/**
 * 具体工厂
 * 在工厂内部指定好,而不需要再调用时去指定.
 */
public class Factory implements IFactory {

	@Override
	public IBook createBook() {
		return new Book("A","java核心技术");
	}

	@Override
	public IGame createGame() {
		return new Game("A","DOTA");
	}

	@Override
	public IProduct createProduct() {
		return new Product("A","BEATS");
	}

}
