package com.demo;

/**
 * 备忘录对象
 */
public class GamePlayerBackup {
    private String name;    //角色名
    private int hp;    //血量
    private int mp;    //魔法
    private int level;    //等级

    public GamePlayerBackup(String name, int hp, int mp, int level) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.level = level;
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
}
