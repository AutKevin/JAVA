package com.qy.BenzImpl;

import com.qy.BenzIntf.Benz;
import com.qy.BenzIntf.BenzFactory;

/**
 * C180的工厂类(只能生产C180)
 */
public class BenzC180Factory implements BenzFactory {
	
	@Override
	public Benz create() {
		return new BenzC180();
	}

}
