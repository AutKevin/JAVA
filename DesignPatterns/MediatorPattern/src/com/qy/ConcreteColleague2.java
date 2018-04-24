package com.qy;

/**
 * 具体同事类2
 */
public class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void action() {
        System.out.println("这是具体同事类2的方法!");
    }
}
