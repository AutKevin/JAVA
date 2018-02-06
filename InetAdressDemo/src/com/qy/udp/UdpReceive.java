package com.qy.udp;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *  实现udp接收端
 *  用java.net.DatagramPackage 接受数据
 *  用java.net.DatagramSocket 接受数据包
 *
 *  步骤
 *  1.创建DatagramSocket对象,绑定端口号(要和发送端端口一致)
 *    DatagramSocket(port)
 *  2.创建字节数组用来接受数据
 *  3.创建数据对象包DatagramPackage
 *    DatagramPacket(data,data.length)
 *  4.创建DatagramSocket
 *    receive(DatagramPackage dp)接受数据,将数据封装如dp中
 *  5.拆包
 *    发送端的ip地址(DatagramPackage.getAddress())
 *    接受到的字节数组
 *    发送的端口号
 *  6.关闭资源
 * Created by Autumn on 2018/2/5.
 */
public class UdpReceive {
    public static void main(String[] args) throws IOException {
        //创建数据包传输的对象,并绑定端口号
        DatagramSocket ds = new DatagramSocket(6000);
        //创建字节数组
        byte[] data = new byte[1024];
        while(true){
            //创建数据包对象,传递字节数组
            DatagramPacket dp = new DatagramPacket(data,data.length);
            //调用ds对象的receive接受数据包,receive()有线程阻塞效果会一直等待接受数据
            ds.receive(dp);

            //获取数据包大小
            int len = dp.getLength();
            //获取发送端的ip地址
            InetAddress sendAddress = dp.getAddress();
            String sendHostAddress = sendAddress.getHostAddress();
            //System.out.println(sendHostAddress);
            //获取发送端端口号
            int port = dp.getPort();
            //System.out.println(port);

            //System.out.println(new String(data));   //直接打印1024个字节的字符串,有很多空格
            System.out.println(sendHostAddress+":"+port+"    "+new String(data,0,len));   //这样打印没有多余的空格

            if(new String(data,0,len).equals("exit")){
                break;
            }
        }
        //关闭
        ds.close();
    }
}
