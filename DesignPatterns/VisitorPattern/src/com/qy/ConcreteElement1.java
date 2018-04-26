package com.qy;

/**
 * 具体元素1
 */
public class ConcreteElement1 extends Element{

    //接收操作
    @Override
    public void accept(Visitor vi) {
        vi.visit(this);
    }

    //业务逻辑方法
    public void operation(){
        System.out.println("访问元素一");
    }
}
