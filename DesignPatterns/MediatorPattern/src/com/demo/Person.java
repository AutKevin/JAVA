package com.demo;

/**
 * 人抽象类
 */
public abstract class Person {
    String name; //姓名
    int age;  //年龄
    Sex sex;   //性别

    int requestAge;   //要求对象的年龄.对对象
    Person requestPerson;

    MarriageAgency agency;    //婚姻中介

    /**
     * @param name 姓名
     * @param age 年龄
     * @param sex 性别
     * @param requestAge 要求对象年龄
     * @param agency 中介所
     */
    public Person(String name, int age, Sex sex, int requestAge, MarriageAgency agency) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.requestAge = requestAge;
        this.agency = agency;

        agency.register(this);    //注册会员,将自己注册到中介所中
    }

    public void findPartner(){    //寻找对象
        agency.pair(this);    //根据自己的数据(obj.requestPerson)查找
    }
}
