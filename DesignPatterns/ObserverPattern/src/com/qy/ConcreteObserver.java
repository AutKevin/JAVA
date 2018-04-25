package com.qy;

/**
 * 具体观察者
 */
public class ConcreteObserver implements Observer {
    @Override
    public void update() {
        System.out.println("订阅者一收到通知,进行处理");
    }
}
