package com.demo;

/**
 * Created by Autumn on 2018/4/27.
 */
public class Main {
    public static void main(String[] args) {
        Variables v = new Variables();    //环境角色
        //终结符
        Variable x = new Variable();
        Variable y = new Variable();
        Variable z = new Variable();
        //将终结符注册到环境中
        v.put(x,10);
        v.put(y,20);
        v.put(z,30);

        //计算x*(y+z/x)-x
        //非终结符接口 = new 非终结符(终结符,终结符),将两个终结符注册到非终结符中操作
        ArithmeticExpression e = new Substract(new Multiply(x,new Plus(y,new Division(z,x))),x);
        //解析非终结符接口 => 非终结符成员变量(终结符)相互操作 => 终结符.interpret(环境角色)  =>  环境角色.get(this)获取终结符代表的值,拿这些值进行操作
        int result = e.interpret(v);
        System.out.println(result);

    }
}
