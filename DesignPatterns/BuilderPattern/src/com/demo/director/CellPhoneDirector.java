package com.demo.director;

import com.demo.abs.CellPhoneBuilder;
import com.demo.impl.Mate7;
import com.demo.impl.Mate7Build;
import com.demo.impl.Mx4Pro;
import com.demo.impl.Mx4ProBuild;

/**
 * 导演者(Director)
 * 负责安排构建的顺序
 */
public class CellPhoneDirector {
	private CellPhoneBuilder cellPhoneBuilder = null;
	
	public Mate7 buildMate7() {
		cellPhoneBuilder = new Mate7Build();
		cellPhoneBuilder.buildCPU();
		cellPhoneBuilder.buildRAM();
		cellPhoneBuilder.buildScreen();
		cellPhoneBuilder.buildBattery();
		cellPhoneBuilder.buildFacade();
		cellPhoneBuilder.buildOthers();
		return (Mate7) cellPhoneBuilder.getPhone();
	}
	
	public Mx4Pro buildMx4Pro(){
		cellPhoneBuilder = new Mx4ProBuild();
		cellPhoneBuilder.buildCPU();
		cellPhoneBuilder.buildRAM();
		cellPhoneBuilder.buildScreen();
		cellPhoneBuilder.buildBattery();
		cellPhoneBuilder.buildFacade();
		cellPhoneBuilder.buildOthers();
		return (Mx4Pro) cellPhoneBuilder.getPhone();
	}
}
