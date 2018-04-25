package com.demo;

/**
 * Created by Autumn on 2018/4/25.
 */
public class Main {

    public static void main(String[] args) {
        //被观察者-发说说的人
        ConcreteTalkSubject subject = new ConcreteTalkSubject();
        ITalkObserver observer = new ConcreteObserver("马云");   //观察者-微信好友
        subject.registerObserver(observer);    //主题添加观察者
        observer = new ConcreteObserver("刘强东");    //观察者-微信好友
        subject.registerObserver(observer);
        subject.sendMsg("也不知道为什么,就是想发条说说~");
    }
}
