package com.qy.facade;

import com.qy.subsys.ClassA;
import com.qy.subsys.ClassB;
import com.qy.subsys.ClassC;

/**
 * 外观角色
 * 对于子系统的访问需要通过外观角色进行
 */
public class Facade {
	//被委托的对象
	private ClassA a = new ClassA();
	private ClassB b = new ClassB();
	private ClassC c = new ClassC();
	
	public void methodA(){
		a.methodA();
	}
	
	public void methodB(){
		b.methodB();
	}
	
	public void methodC(){
		c.methodC();
	}
}
