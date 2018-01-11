package com.demo.impl;

import com.demo.inf.IPrize;

/**
 * 具体享元角色
 **/
public class PrizeFlyweight implements IPrize {
	//奖品 - 内部状态
	private String prizeName;
	
	public PrizeFlyweight(String prizeName) {
		this.prizeName = prizeName;
	}
	
	@Override
	public void LuckDraw(String result) {
		if ("中奖".equals(result)) {
			System.out.println("恭喜中了大奖,奖品是："+prizeName);
		}else {
			System.out.println("很遗憾您没有中奖!欢迎再来一次!");
		}
	}

}
