package com.demo;

/**
 * 朋友圈说说抽象主题
 */
public interface ITalkSubject {
    //注册观察者
    public void registerObserver(ITalkObserver observer);
    //删除观察者
    public void delObserver(ITalkObserver observer);
    //通知所有观察者
    public void notifyObserver();
}
