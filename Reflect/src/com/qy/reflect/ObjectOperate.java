package com.qy.reflect;

import com.qy.entity.Student;

import java.lang.reflect.Field;

/**
 * Created by Autumn on 2018/2/2.
 */
public class ObjectOperate {

    public static void main(String[] args) throws Exception {
        Student student = new Student("aeolian",20);
        ObjectOperate.setProperty(student,"age",45);
        System.out.println(ObjectOperate.getProper(student,"name"));
        System.out.println(ObjectOperate.getProper(student,"age"));
    }

    /**
     * 给对象obj的名字为propertyName的属性设置为value
     * @param obj
     * @param propertyName
     * @param value
     * @throws Exception
     */
    public static void setProperty(Object obj, String propertyName, Object value) throws Exception{
        //1.获取obj的字节码对象
        Class clazz = obj.getClass();
        //2.获取propertyName属性对应的Field对象
        Field propertyNameField = clazz.getDeclaredField(propertyName);
        //3.设置成可访问的
        propertyNameField.setAccessible(true);
        //4.调用set方法给对象赋值
        propertyNameField.set(obj, value);
        propertyNameField.setAccessible(false);
    }

    /**
     * 获取变成员变量值
     * 获取object对象,properName变量的值
     * @param object    对象
     * @param properName    成员变量名
     * @return
     * @throws Exception
     */
    public static String getProper(Object object,String properName) throws Exception {
        Class clazz = object.getClass();
        Field fieldName = clazz.getDeclaredField(properName);
        fieldName.setAccessible(true);
        String properValue = fieldName.get(object).toString();
        fieldName.setAccessible(false);
        return properValue;
    }

}
