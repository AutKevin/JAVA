package com.chat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 中介者-聊天室
 */
public class Chat {
    public static void showMessage(User user,String msg){
        System.out.println(new SimpleDateFormat("yyyy-dd-hh-mm-ss").format(new Date())+"   "+user.getName()+": "+msg);
    }
}
