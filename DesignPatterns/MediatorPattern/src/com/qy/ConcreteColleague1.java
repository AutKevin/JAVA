package com.qy;

/**
 * 具体同事类1
 */
public class ConcreteColleague1 extends Colleague {
    //构造函数
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void action() {
        System.out.println("这是同事1的行动方法!");
    }
}
