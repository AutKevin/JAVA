package com.qy;

/**
 * 抽象访问者
 */
public interface Visitor {
    //可以访问哪些元素对象,元素对象传过来,可以执行元素的操作.
    public void visit(ConcreteElement1 el1);
    public void visit(ConcreteElement2 el2);
}
