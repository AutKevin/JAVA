package com.qy.BenzImpl;

import com.qy.BenzIntf.Benz;

public class BenzC180 implements Benz{
	@Override
	public void carColor() {
		System.out.println("C180的颜色是银白色");
	}

	@Override
	public void carSpeed() {
		System.out.println("C180的速度是160公里每小时");
	}

	@Override
	public void carPrice() {
		System.out.println("C180的价格是100万");
	}
}
