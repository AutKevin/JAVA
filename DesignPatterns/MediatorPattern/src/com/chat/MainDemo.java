package com.chat;

/**
 * 测试
 */
public class MainDemo {

    public static void main(String[] args) {
        User u1 = new User("sywer");
        User u2 = new User("catalin");
        u1.sendMsg("hello!");
        u2.sendMsg("bye");
    }
}
