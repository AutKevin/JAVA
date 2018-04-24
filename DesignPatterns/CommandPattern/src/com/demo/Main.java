package com.demo;

/**
 * 测试类
 */
public class Main {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();    //接收者
        Command command1 = new LightOnCommand(receiver);    //开灯命令
        Command command2 = new LightOffCommand(receiver);    //开灯命令
        Invoker invoker = new Invoker();
        invoker.invoker(command1);
        invoker.invoker(command2);
    }
}
