package com.demo;

/**
 * 抽象访问者-里面的方法访问数据结构中的元素
 */
public interface IVisitor {
    //对元素A进行操作
    public void doVisit(MedicineA a);
    //对元素B进行操作
    public void doVisit(MedicineB b);
}
