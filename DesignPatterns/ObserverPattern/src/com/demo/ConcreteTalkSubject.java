package com.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体主题类
 */
public class ConcreteTalkSubject implements ITalkSubject{
    //观察者集合
    List<ITalkObserver> obsList = new ArrayList<ITalkObserver>();
    //朋友圈消息
    String msg = null;

    @Override
    public void registerObserver(ITalkObserver observer) {
        obsList.add(observer);
    }

    @Override
    public void delObserver(ITalkObserver observer) {
        obsList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        if (obsList.size()>0) {
            for (ITalkObserver obs : obsList) {
                obs.updateTalk(this.msg);
            }
        }
    }

    //发送朋友圈消息
    public void sendMsg(String msg){
        this.msg = msg;
        this.notifyObserver();
    }
}
