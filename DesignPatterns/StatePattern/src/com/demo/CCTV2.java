package com.demo;

/**
 * 具体状态
 */
public class CCTV2 implements Channel {
    @Override
    public void display() {
        System.out.println("CCTV2正在播放动物世界");
    }
}
