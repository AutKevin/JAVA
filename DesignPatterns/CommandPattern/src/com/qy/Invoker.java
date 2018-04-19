package com.qy;

/**
 * 调用者
 */
public class Invoker {
    private Command command;
    //接收命令
    public void setCommand(Command command){
        this.command = command;
    }
    //执行命令
    public void action(){
        this.command.execute();
    }
}
