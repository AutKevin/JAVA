package com.qy.tmp;

/**
 * Created by Autumn on 2018/4/18.
 */
public class Client {
    public static void main(String[] args) {
        AbstractClass ac = new ConcreteClass();
        //调用模板方法
        ac.templateMethod();
    }
}
