package com.Cglib;

/*
 * 目标对象
 * 没有实现任何接口
 */
public class RealSubject {
	public void request() {
        System.out.println("----被代理对象请求方法!----");
    }
}
