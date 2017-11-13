package com.qy.BenzImpl;

import com.qy.BenzIntf.Benz;
import com.qy.BenzIntf.BenzFactory2;

/**
 * 第二种方法写工厂模式
 * 生产所有实现Benz类接口的子类对象
 */
public class BenzFactoryImpl2 implements BenzFactory2 {

	@Override
	public <T extends Benz> T createFactory(Class<T> c) {
		Benz benz = null;
		try {
			benz = (Benz) Class.forName(c.getName()).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (T) benz;
	}
	
}
