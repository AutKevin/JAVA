package com.demo;

/**
 * 男人类
 */
public class Man extends Person{
    public Man(String name, int age, int requestAge, MarriageAgency agency) {
        super(name, age, Sex.MALE, requestAge, agency);
    }
}
