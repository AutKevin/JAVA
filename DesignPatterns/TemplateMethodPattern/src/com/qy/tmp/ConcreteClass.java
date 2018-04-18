package com.qy.tmp;

/**
 * 具体模板角色
 */
public class ConcreteClass extends AbstractClass{
    //实现基本业务方法
    @Override
    protected void operation() {
        //业务逻辑
        System.out.println("具体类的操作");
    }

    @Override
    protected void operation2() {
        //业务逻辑
        System.out.println("具体类的操作2");
    }
}
