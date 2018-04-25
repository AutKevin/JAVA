package com.demo;

/**
 * 发起人角色
 */
public class GamePlayer {
    private String name;    //角色名
    private int hp;    //血量
    private int mp;    //魔法
    private int level;    //等级

    public GamePlayerBackup createBackup(){
        return new GamePlayerBackup(this.name,this.hp,this.mp,this.level);
    }

    public void restoreGamePlayer(GamePlayerBackup gpBackup){
        this.setHp(gpBackup.getHp());
        this.setMp(gpBackup.getMp());
        this.setName(gpBackup.getName());
        this.setLevel(gpBackup.getLevel());
    }

    public void KillBoss(){
        System.out.println(this.name+"开始打BOSS");
        while(this.hp>0){    //如果没挂就继续打
            System.out.println(this.name+"使用技能攻击,消耗30MP.MP剩余:"+(this.mp-=30));
            System.out.println("Boss攻击"+this.name+"HP减50.HP剩余:"+(this.hp-=50));
            System.out.println(this.toString());
            if (this.hp<=0){
                System.out.println("游戏角色"+this.name+"被Boss击杀!");
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public GamePlayer(String name, int hp, int mp, int level) {

        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.level = level;
    }

    @Override
    public String toString() {
        return "游戏角色{" +
                "角色名='" + name + '\'' +
                ", 血量=" + hp +
                ", 法力值=" + mp +
                ", 等级=" + level +
                '}';
    }

    public GamePlayerBackup2 createBackup2(){
        return new GamePlayerBackup2(this);
    }

    public void restoreGamePlayer(GamePlayerBackup2 gpBackup){
        this.setHp(gpBackup.getGamePlayer().getHp());
        this.setMp(gpBackup.getGamePlayer().getMp());
        this.setName(gpBackup.getGamePlayer().getName());
        this.setLevel(gpBackup.getGamePlayer().getLevel());
    }
}
