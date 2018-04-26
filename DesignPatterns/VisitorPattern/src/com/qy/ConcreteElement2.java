package com.qy;

/**
 * 具体元素2
 */
public class ConcreteElement2 extends Element{

    //接收操作,元素自己作为参数传递到访问者元素中去
    @Override
    public void accept(Visitor vi) {
        vi.visit(this);
    }

    //业务逻辑方法
    public void operation(){
        System.out.println("访问元素二");
    }
}
