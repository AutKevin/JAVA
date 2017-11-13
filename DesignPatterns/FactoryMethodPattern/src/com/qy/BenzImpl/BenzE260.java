package com.qy.BenzImpl;

import com.qy.BenzIntf.Benz;

public class BenzE260 implements Benz {

	@Override
	public void carColor() {
		System.out.println("E260的颜色是红色");
	}

	@Override
	public void carSpeed() {
		System.out.println("E260的速度是180公里每小时");
	}

	@Override
	public void carPrice() {
		System.out.println("E260的价格是120万");
	}

}
