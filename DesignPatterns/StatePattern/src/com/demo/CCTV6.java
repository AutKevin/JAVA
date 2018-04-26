package com.demo;

/**
 * 具体状态
 */
public class CCTV6 implements Channel {
    @Override
    public void display() {
        System.out.println("CCTV6正在播放电影");
    }
}
