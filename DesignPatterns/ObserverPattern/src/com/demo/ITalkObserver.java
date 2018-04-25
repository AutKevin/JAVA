package com.demo;

/**
 * 抽象观察者
 */
public interface ITalkObserver {
    //接受朋友圈信息,msg为发说说的人
    public void updateTalk(String msg);
}
