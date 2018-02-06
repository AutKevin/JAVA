package com.qy.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 实现udp发送端
 *  用java.net.DatagramPackage封装数据
 *  用java.net.DatagramSocket发送数据
 *
 * 实现步骤
 *  1.用DatagramPackage对象,封装数据,接受的地址和端口
 *  2.创建DatagramSocket
 *  3.调用DatagramSocket对象send方法,发送数据
 *  4.关闭资源
 *
 *  DatagramPackage构造函数
 *    DatagramPacket(byte[] buf, int length, InetAddress address, int port)
 *  DatagramSocket构造函数
 *    DatagramSocket()
 *    方法:send(DatagramPacket d)
 *  Created by Autumn on 2018/2/5.
 */
public class UdpSend {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        //获取地址
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        //创建DatagramSocket,负责接受和发送数据
        DatagramSocket ds = new DatagramSocket();
        while(true){
            String msg = scanner.nextLine();
            //创建数据包对象对象
            byte[] data = msg.getBytes();
            //封装数据,接受的地址和端口
            DatagramPacket dp = new DatagramPacket(data,data.length,inet,6000);

            //发送数据包
            ds.send(dp);
            if(msg.equals("exit")){
                break;
            }
        }
        //关闭
        ds.close();
    }
}
