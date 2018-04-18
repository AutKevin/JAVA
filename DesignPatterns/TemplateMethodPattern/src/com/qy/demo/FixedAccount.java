package com.qy.demo;

/**
 * 具体模板类,定期账户
 */
public class FixedAccount extends Account {

    /**
     * 基本方法,确定账户类型
     * @return
     */
    protected String getAccountType() {
        return "一年定期";
    }

    /**
     * 基本方法,确定利息
     * @return
     */
    protected double getInterestRate() {
        return 0.04D;
    }
}
