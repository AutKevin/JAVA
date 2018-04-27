package com.demo;

/**
 * 抽象解释器
 */
public interface ArithmeticExpression {
    int interpret(Variables variables);
}
