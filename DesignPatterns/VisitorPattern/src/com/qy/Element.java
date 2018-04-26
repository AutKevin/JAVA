package com.qy;

/**
 * 抽象元素角色
 */
public abstract class Element {
    //接收访问者操作,访问者会把具体元素传入到访问者角色中
    public abstract void accept(Visitor vi);
}
