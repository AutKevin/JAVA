package com.demo;

/**
 * 药单---数据结构(元素为药品)
 */
public class MedicineList {
    private MedicineA a;
    private MedicineB b;

    //构造函数初始化元素
    public MedicineList() {
        this.a = new MedicineA("板蓝根",8.8);
        this.b = new MedicineB("白加黑",16.0);
    }

    public void accept(IVisitor visitor){
        this.a.accept(visitor);
        this.b.accept(visitor);
    }
}
