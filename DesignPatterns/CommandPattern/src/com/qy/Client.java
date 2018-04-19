package com.qy;

/**
 * 测试类
 */
public class Client {
    public static void main(String[] args) {
        //调用者
        Invoker invoker = new Invoker();
        //接收者
        Receiver receiver = new Receiver();
        //定义一个发送给接收者的命令
        Command command = new ConcreteCommand(receiver);
        //执行
        invoker.setCommand(command);
        invoker.action();
    }
}
