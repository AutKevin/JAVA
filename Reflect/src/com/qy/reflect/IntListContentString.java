package com.qy.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 在Integer类型List中添加String
 * Created by Autumn on 2018/2/2.
 */
public class IntListContentString {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //new一个int型的list
        List<Integer> intList = new ArrayList<Integer>();
        //加入int成员
        intList.add(8);
        intList.add(10);
        System.out.println(intList);

        //在jvm中加载class
        Class clazz = Class.forName("java.util.ArrayList");
        //从class中获取add(String)方法
        Method addMethod = clazz.getMethod("add", Object.class);
        //method类invoke方法(调用它的对象,方法参数)
        addMethod.invoke(intList, "this is a string");
        System.out.println(intList);
    }
}
