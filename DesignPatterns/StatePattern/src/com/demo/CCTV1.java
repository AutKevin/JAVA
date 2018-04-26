package com.demo;

/**
 * 具体状态
 */
public class CCTV1 implements Channel {
    @Override
    public void display() {
        System.out.println("CCTV1正在播放新闻联播");
    }
}
