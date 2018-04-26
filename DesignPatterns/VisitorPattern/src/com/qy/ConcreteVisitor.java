package com.qy;

/**
 * 具体访问者角色
 */
public class ConcreteVisitor implements Visitor {

    //访问元素1
    @Override
    public void visit(ConcreteElement1 el1) {
        el1.operation();
    }

    //访问元素2
    @Override
    public void visit(ConcreteElement2 el2) {
        el2.operation();
    }
}
