package com.demo;

/**
 * 调用者
 */
public class Invoker {
    public void invoker(Command command){
        command.execute();    //执行命令
    }
}
