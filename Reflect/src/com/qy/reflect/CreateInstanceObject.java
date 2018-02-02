package com.qy.reflect;

import com.qy.entity.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 根据反射生成对象
 * 方案一:类直接实例化clazz.newInstance();
 *        对象的值可以根据Field设置也可以根据Method设置。
 * 方案二:根据类获取构造函数,然后用构造函数实例化clazz.getConstructor(String.class, int.class);
 *        根据构造函数实例化对象(Student) constructor.newInstance("雷军", 23);
 * Created by Autumn on 2018/2/2.
 */
public class CreateInstanceObject {
    public static void main(String[] args) throws Exception {
        //加载class
        Class clazz = Class.forName("com.qy.entity.Student");

        //根据class实例化一个对象
        Student s1 = (Student) clazz.newInstance();   //必须要有无参构造函数,否则抛InstantiationException异常
        //根据class获取成员变量,初始化对象的值
        Field fieldName = clazz.getDeclaredField("name");   //getField只能获得public的字段,要想获得全部字段要用getDeclaredField
        Field fieldAge = clazz.getDeclaredField("age");
        //将字段可读性设为true,取消java访问检查
        fieldName.setAccessible(true);
        fieldAge.setAccessible(true);
        //根据字段给对象设值
        fieldName.set(s1,"李彦宏");    //设置字段值set(对象,字段值)
        fieldAge.set(s1,21);         //反射都是把对象作为参数
        System.out.println(s1.toString());

        //根据class获取成员方法,初始化对象的值
        Method methodSetName = clazz.getMethod("setName", String.class);
        Method methodSetAge = clazz.getMethod("setAge", int.class);
        methodSetName.invoke(s1,"刘强东");
        methodSetAge.invoke(s1,22);
        System.out.println(s1.toString());


        //根据class获取构造函数,然后再根据构造函数实例化一个对象并实例化对象的值.
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        //根据构造函数生成对象
        Student s2 = (Student) constructor.newInstance("雷军", 23);
        System.out.println(s2.toString());
    }
}
