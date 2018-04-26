package com.qy;

/**
 * 具体状态2
 */
public class ConcreteState2 extends State {
    //状态2的行为逻辑处理
    @Override
    public void handle() {
        System.out.println("行为二的逻辑处理");
    }
}
