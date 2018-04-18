package com.qy.demo;

/**
 * 抽象模板,抽象账户类
 */
public abstract class Account {
    //账号
    private String accountNumber;

    //构造函数
    public Account(){
        accountNumber = null;
    }
    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * 基本方法,确定账户类型,留给子类实现
     * @return
     */
    protected abstract String getAccountType();

    /**
     * 基本方法,确定利息,留给子类实现
     * @return
     */
    protected abstract double getInterestRate();

    /**
     * 基本方法,根据账户类型和账户确定账户金额
     * @param accountType
     * @param accountNumber
     * @return
     */
    public double calculateAmount(String accountType,String accountNumber){
        //访问数据库...此处直接返回账户金额
        return 10000.00D;
    }

    //模板方法,计算账户利息
    public double calculateInterest(){
        String accountType = getAccountType();
        double interestRate = getInterestRate();
        double amount = calculateAmount(accountType,accountNumber);
        return amount*interestRate;
    }

}
