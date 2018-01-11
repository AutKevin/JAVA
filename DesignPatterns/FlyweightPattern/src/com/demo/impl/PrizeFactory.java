package com.demo.impl;

import java.util.HashMap;
import java.util.Map;

import com.demo.inf.IPrize;

/**
 * 奖票工厂类 
 **/
public class PrizeFactory {
	private static Map<String, IPrize> prizePool = new HashMap<String, IPrize>();
	private PrizeFactory() {}    //私有化,防止生成多个工厂
	
	/**
	 * 根据奖品名称获得奖品对象
	 * @param prizeName
	 * @return
	 */
	public static IPrize getInstance(String prizeName){
		IPrize prize = prizePool.get(prizeName);
		if (prize == null) {
			prize = new PrizeFlyweight(prizeName);
			prizePool.put(prizeName, prize);
		}
		return prize;
	}
}
