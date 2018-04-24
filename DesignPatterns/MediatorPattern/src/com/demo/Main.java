package com.demo;

/**
 * 测试类
 */
public class Main {
    public static void main(String[] args) {
        MarriageAgency agency = new MarriageAgencyImpl();
        //姓名为allen,27岁的man对象,寻找28岁异性
        //agency为中介所,在构造函数中会把自己构造的对象传递到angency中
        Person m1 = new Man("allen",27,28,agency);
        Person m2 = new Man("sywer",25,20,agency);
        Person w1 = new Woman("catalin",28,23,agency);
        Person w2 = new Woman("feilicity",25,23,agency);
        m1.findPartner();   //调用agency.find(this)，即m1执行此方法调用中介所的find方法,而本身作为一个参数.
        m2.findPartner();
    }
}
