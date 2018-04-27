package com.qy;

/**
 * 抽象表达式.
 */
public abstract class AbstractExpression {
    //每个表达式必须有一个解析任务
    public abstract Object interpreter();
}
