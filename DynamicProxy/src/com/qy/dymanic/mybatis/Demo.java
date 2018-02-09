package com.qy.dymanic.mybatis;

import java.util.List;

/**
 * 接口无子类代理对象
 */
public class Demo {
    public static void main(String[] args) {
        Myinterface inf = SqlSession.getMapper(Myinterface.class);
        List<Object> result = inf.queryList();
        System.out.println("返回结果："+result);
        System.out.println("----------------------------------------");
        System.out.println("返回结果："+inf.getName());
        System.out.println("----------------------------------------");
    }
}
