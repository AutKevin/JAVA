package com.qy;

/**
 * 抽象主题-被观察者
 */
public interface Subject {
    //登记一个新的观察者
    public void attach(Observer observer);
    //删除一个等级过的观察者
    public void detach(Observer observer);
    //通知所有登记过的观察者对象
    public void notifyObserver();
}
