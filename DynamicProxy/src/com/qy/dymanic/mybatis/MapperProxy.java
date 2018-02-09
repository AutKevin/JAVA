package com.qy.dymanic.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 代理方法,Mybatis中接口无实例类,
 * 所以此处理并不是在方法执行前后加日志等处理
 * 而是生成数据库操作执行体
 */
public class MapperProxy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("通过接口与method获取对应的配置文件中的信息：");
        System.out.println("接口名称.方法名==namespace.id");
        System.out.println("通过配置文件中的信息获取SQL语句的类型");
        System.out.println("根据SQL语句类型调用sqlSession对应的增删改查方法");
        System.out.println("当SQL语句类型是查询时");
        System.out.println("根据返回值的类型是List、Map、Object");
        System.out.println("分别调用selectList、selectMap、selectOne方法");

        //模拟数据,当方法名为queryList时
        if (method.getName().equals("queryList")) {
            List list = new ArrayList();
            list.add(1);
            list.add(2);
            list.add("autumn");
            return list;
        }
        //模拟数据当放回类型为String时
        if (method.getReturnType().toString().equals(String.class.toString())){
            return "查询数据库返回的字符串";
        }
        return null;
    }
}
