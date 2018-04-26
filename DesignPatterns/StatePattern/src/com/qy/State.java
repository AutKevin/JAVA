package com.qy;

/**
 * 抽象状态
 */
public abstract class State {
    //定义一个环境角色
    protected Context context;
    //设置环境
    public void setContext(Context context){
        this.context = context;
    }
    //抽象行为
    public abstract void handle();
}
