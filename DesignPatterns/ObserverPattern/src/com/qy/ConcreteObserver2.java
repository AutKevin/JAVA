package com.qy;

/**
 * 具体观察者
 */
public class ConcreteObserver2 implements Observer {
    @Override
    public void update() {
        System.out.println("订阅者二收到通知,进行处理");
    }
}
