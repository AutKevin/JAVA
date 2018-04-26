package com.demo;

/**
 * 药剂师取药--访问者
 */
public class PharmacistsVisitor implements IVisitor{
    //访问数据结构中的元素A
    @Override
    public void doVisit(MedicineA a) {
        System.out.println("药剂师拿药:"+a.getName());
    }

    //访问数据结构中的元素B
    @Override
    public void doVisit(MedicineB b) {
        System.out.println("药剂师拿药:"+b.getName());
    }
}
