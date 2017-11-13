package com.qy.impl;

import com.qy.intf.Creator;
import com.qy.intf.Product;

/**
 * 具体工厂角色接口
 */
public class ConcreteCreator implements Creator {

	@Override
	public <T extends Product> T factory(Class<T> c) {
		Product product = null;
		try {
			product = (Product) Class.forName(c.getName()).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (T)product;
	}

}
