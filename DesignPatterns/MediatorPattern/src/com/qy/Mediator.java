package com.qy;

/**
 * 抽象中介者模式
 */
public abstract class Mediator {
    //中介者模式的业务逻辑方法
    public abstract void colleagueChanged(Colleague colleague);
}
