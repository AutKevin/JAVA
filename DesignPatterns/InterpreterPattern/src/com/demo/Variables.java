package com.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * 环境角色--使用Map存储各个变量的值
 */
public class Variables {
    //key为变量类型,value为变量值.Variable为封装int的包装类
    Map<Variable,Integer> v = new HashMap<Variable,Integer>();
    //封装值,将终结符及其对应的解释封装到环境角色
    public void put(Variable variable,int value){
        v.put(variable,value);
    }
    //取值,从环境角色中取出非终结符对应的值
    public int get(Variable variable){
        return v.get(variable);
    }
}
