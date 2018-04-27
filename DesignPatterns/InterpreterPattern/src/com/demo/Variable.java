package com.demo;

/**
 * 算数表达式中的变量--终结符角色
 */
public class Variable implements ArithmeticExpression {
    @Override
    public int interpret(Variables variables) {
        return variables.get(this);
    }
}
