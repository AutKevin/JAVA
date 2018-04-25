package com.qy;

/**
 * 测试类
 */
public class Client {
    public static void main(String[] args) {
        Originator org = new Originator();
        //定义负责人
        Caretaker caretaker = new Caretaker();
        System.out.println("初始值:"+org.getState());
        //创建一个备忘录
        caretaker.setMemento(org.createMemento());

        org.setState("改变初始值");
        System.out.println("改变后:"+org.getState());
        //恢复备忘录
        org.restoreMemento(caretaker.getMemento());
        System.out.println("恢复后的值:"+org.getState());
    }
}
