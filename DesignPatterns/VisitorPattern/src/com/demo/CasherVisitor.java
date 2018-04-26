package com.demo;

/**
 * 对药品收费---访问者对元素进行访问
 */
public class CasherVisitor implements IVisitor {

    //访问数据结构中的元素A
    @Override
    public void doVisit(MedicineA a) {
        System.out.println("收费员对:"+a.getName()+"进行收费"+a.getPrice()+"元");
    }

    //访问数据结构中的元素B
    @Override
    public void doVisit(MedicineB b) {
        System.out.println("收费员对:"+b.getName()+"进行收费"+b.getPrice()+"元");
    }

}
