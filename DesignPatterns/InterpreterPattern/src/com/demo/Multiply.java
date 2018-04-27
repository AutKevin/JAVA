package com.demo;

/**
 * 乘算法--非终结符角色
 */
public class Multiply implements ArithmeticExpression {
    ArithmeticExpression left;      //终结符角色
    ArithmeticExpression right;     //终结符角色

    public Multiply(ArithmeticExpression left, ArithmeticExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Variables variables) {
        //终结符角色.interpret(环境角色)-->环境角色.get(this)获取终结符角色在环境角色中注册的值
        return left.interpret(variables)*right.interpret(variables);
    }
}
