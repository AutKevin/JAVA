package com.demo;

/**
 * 药品B-数据结构元素
 */
public class MedicineB extends Medicine{
    public MedicineB(String name, Double price) {
        super(name, price);
    }
    //对药品进行操作
    @Override
    public void accept(IVisitor visitor) {
        visitor.doVisit(this);
    }
}
