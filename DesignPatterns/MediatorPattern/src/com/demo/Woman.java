package com.demo;

/**
 * 女人类
 */
public class Woman extends Person{
    public Woman(String name, int age, int requestAge, MarriageAgency agency) {
        super(name, age, Sex.FEMALE, requestAge, agency);
    }
}
