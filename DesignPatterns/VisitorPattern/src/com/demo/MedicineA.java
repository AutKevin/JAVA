package com.demo;

/**
 * 药品A--数据结构元素
 */
public class MedicineA extends Medicine{
    public MedicineA(String name, Double price) {
        super(name, price);
    }

    //元素接收访问者
    @Override
    public void accept(IVisitor visitor) {
        visitor.doVisit(this);    //元素将自己交给访问者
    }
}
