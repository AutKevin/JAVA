package com.demo;

/**
 * 电视--环境角色
 */
public class TV {
    private Channel channel1 = new CCTV1();
    private Channel channel2 = new CCTV2();
    private Channel channel6 = new CCTV6();
    //当前频道
    private Channel curChanel;

    public Channel getCurChanel() {
        return curChanel;
    }

    public void setCurChanel(Channel curChanel) {
        this.curChanel = curChanel;
    }

    public void displayCCTV1(){
        this.setCurChanel(channel1);
        this.curChanel.display();
    }

    public void displayCCTV2(){
        this.setCurChanel(channel2);
        this.curChanel.display();
    }

    public void displayCCTV6(){
        this.setCurChanel(channel6);
        this.curChanel.display();
    }

}
