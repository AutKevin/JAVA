package com.qy.dymanic.mybatis;

import java.lang.reflect.Proxy;

/**
 * Mybatis原理根据接口名称获取代理实例
 */
public class SqlSession {
    /**
     * 获取接口代理对象实例
     * @param inf 接口
     * @param <T> 该接口的代理对象实例
     * @return
     */
    public static <T> T getMapper(Class<T> inf){
        System.out.println("Mybatis通过接口的Class从代理工厂Map取出对应的代理工厂");
        System.out.println("Mybatis通过代理工厂实例化一个代理类");
        System.out.println("Mybatis用这个代理类生成一个代理实例返回出去");
        System.out.println("Mybatis的这个代理实例没有被代理对象,所以代理类的方法体就是所有的方法内容");

       return (T)Proxy.newProxyInstance(inf.getClassLoader(),new Class[]{inf},new MapperProxy());
    }
}
