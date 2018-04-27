package com.qy;

/**
 * 终结符表达式
 */
public class TerminalExpression extends AbstractExpression {
    //通常终结符表达式只有一个,但是有多个对象
    @Override
    public Object interpreter() {
        return null;
    }
}
