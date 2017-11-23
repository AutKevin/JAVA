package com.Cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class ProxyFactory implements MethodInterceptor {
	//维护目标对象
    private Object target;
    public ProxyFactory(Object target) {
        this.target = target;
    }
    //给目标对象创建一个代理对象
    public Object getProxyInstance(){
    	//1.工具类
    	Enhancer enhancer = new Enhancer();
    	//2.设置父类
    	enhancer.setSuperclass(target.getClass());
    	//3.设置调用函数
    	enhancer.setCallback(this);
    	//4.创建子类(代理对象)
    	return enhancer.create();
    }
	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		beforeRequest();
        //执行目标对象的方法
		Object returnvalue = method.invoke(target, args);
		afterRequest();
		return returnvalue;
	}
	
	//请求前的操作
	public void beforeRequest(){
		//预处理
		System.out.println(target.getClass()+"被代理了,在它执行之前要执行预处理方法");
	}
	//请求后的操作
	public void afterRequest(){
		//善后处理
		System.out.println(target.getClass()+"被代理了,在它执行之后要执行善后方法");
	}
}
