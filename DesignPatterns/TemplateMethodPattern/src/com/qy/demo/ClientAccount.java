package com.qy.demo;

/**
 * 测试类
 */
public class ClientAccount {
    public static void main(String[] args) {
        Account account = new DemandAccount();
        System.out.println("活期账户利息:"+account.calculateInterest());
        account = new FixedAccount();
        System.out.println("一年定期账户利息:"+account.calculateInterest());
    }
}
