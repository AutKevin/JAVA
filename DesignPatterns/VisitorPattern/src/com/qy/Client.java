package com.qy;

/**
 * Created by Autumn on 2018/4/26.
 */
public class Client {
    public static void main(String[] args) {
        //创建一个结构对象,类似于列表结构的os
        ObjectStructure os = new ObjectStructure();
        //生成元素,给os生成十个元素
        os.createElements();

        //创建一个访问者对象
        Visitor vi = new ConcreteVisitor();
        //结构对象调用访问者对结构对象进行访问,访问者对结构中的元素进行访问(执行访问)
        //1.先把访问者vi传入结构体中,
        //2.循环结构体每一个元素将vi传到每一个具体元素中,
        //3.元素方法中调用vi.visit(this)将自己作为参数传到访问者中,
        //4.访问者获取到具体元素即可进行操作
        os.action(vi);
    }
}
