package com.qy;

/**
 * 抽象同事类
 */
public abstract class Colleague {
    private Mediator mediator;
    //构造函数
    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
    //getter和setter方法
    public Mediator getMediator() {
        return mediator;
    }
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    //抽象行动方法,由子类实现
    public abstract void action();
    //业务方法,调用此方法改变对象的内部状态
    public void change(){
        this.mediator.colleagueChanged(this);
    }

}
