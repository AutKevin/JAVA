package com.chat;

/**
 * 聊天用户
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public void sendMsg(String msg){
        Chat.showMessage(this,msg);    //中介者静态方法,所以同事类中不需要有中介者对象
    }
}
