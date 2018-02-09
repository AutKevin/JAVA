package com.qy.dymanic.jdkproxycode;

import java.lang.reflect.Method;

import com.qy.dymanic.jdkproxycode.InvocationHandler;

public class $Proxy0 implements com.qy.dymanic.jdkproxycode.Moveable {
    public $Proxy0(InvocationHandler h) {
        this.h = h;
    }

    private InvocationHandler h;

    @Override
    public void move() {
        try {
            Method md = com.qy.dymanic.jdkproxycode.Moveable.class.getMethod("move");
            h.invoke(this, md);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}