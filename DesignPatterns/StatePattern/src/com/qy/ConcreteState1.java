package com.qy;

/**
 * 具体状态
 */
public class ConcreteState1 extends State {
    //状态1的行为逻辑处理
    @Override
    public void handle() {
        System.out.println("行为一的逻辑处理");
    }
}
