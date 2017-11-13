package com.qy.BenzImpl;

import com.qy.BenzIntf.Benz;
import com.qy.BenzIntf.BenzFactory;

/**
 * E260的工厂类(只能生产E260)
 */
public class BenzE260Factory implements BenzFactory{

	@Override
	public Benz create() {
		return new BenzE260();
	}

}
