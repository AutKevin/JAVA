package com.qy;

/**
 * 非终结符表达式
 */
public class NonterminalExpression extends AbstractExpression {
    //每个非终结符表达式都会对其他表达式产生依赖
    public NonterminalExpression(AbstractExpression expression) {
    }

    @Override
    public Object interpreter() {
        //进行文法处理
        return null;
    }
}
