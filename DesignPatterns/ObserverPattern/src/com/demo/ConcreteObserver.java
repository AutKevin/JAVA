package com.demo;

/**
 * 具体观察者
 */
public class ConcreteObserver implements ITalkObserver {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    //接受消息
    @Override
    public void updateTalk(String msg) {
        System.out.println(name+"接受消息:"+msg);
    }
}
