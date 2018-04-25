package com.demo;


import com.qy.Caretaker;

/**
 * Created by Autumn on 2018/4/25.
 */
public class Main {
    public static void main(String[] args) {
        GamePlayer gamePlayer = new GamePlayer("李逍遥",500,500,20);   //发起人角色
        System.out.println("初始状态"+gamePlayer.toString());

        CareTaker caretaker = new CareTaker();   //负责人角色
        caretaker.setGpBackup(gamePlayer.createBackup());   //发起人创建备忘录角色并传给负责人保管

        gamePlayer.KillBoss();   //打怪

        //恢复备忘录角色
        gamePlayer.restoreGamePlayer(caretaker.getGpBackup());
        System.out.println("--------游戏角色复活--------"+gamePlayer.toString());

        GamePlayerBackup2 gpbackup2 = gamePlayer.createBackup2();    //备份将自己赋值给gpbackup2的一个GamePlayer字段,它们指向的是同一个对象
        System.out.println("初始状态"+gamePlayer.toString());
        gamePlayer.KillBoss();   //打怪      //数据变化,gamePlayer和gpbackup2的字段指向同一个对象
        gamePlayer.restoreGamePlayer(gpbackup2);
        System.out.println("--------游戏角色复活不了!!!!--------"+gamePlayer.toString());

    }
}
