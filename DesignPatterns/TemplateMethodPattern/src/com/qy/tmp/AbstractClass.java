package com.qy.tmp;

/**
 * 抽象模板角色
 */
public abstract class AbstractClass {
    //基本方法
    protected abstract void operation();
    //基本方法2
    protected abstract void operation2();

    //模板方法
    public void templateMethod(){
        //调用基本方法,完成相关逻辑
        this.operation();
        this.operation2();
    }

}
