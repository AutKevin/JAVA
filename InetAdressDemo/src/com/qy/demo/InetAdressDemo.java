package com.qy.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ip地址和主机名工具类
 * Created by Autumn on 2018/2/5.
 */
public class InetAdressDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAdressDemo.getLocalHost();
        System.out.println("---------------------------");
        getHostByName("Lenovo-Autumn");
    }

    /**
     * 获取主机ip和主机名
     * @throws UnknownHostException
     */
    public static void getLocalHost() throws UnknownHostException {
        //根据InetAddress获取主机名和主机ip
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);   //打印:Lenovo-Autumn/192.168.56.1

        //根据getLocalHost()返回的值获取ip和主机名
        String hostName = localHost.getHostName();
        String hostAddress = localHost.getHostAddress();
        System.out.println(hostName); //打印 Lenovo-Autumn
        System.out.println(hostAddress); //打印 192.168.56.1

        //根据切割获取主机名和ip
        String[] str = localHost.toString().split("/");
        System.out.println(str[0]); //打印 Lenovo-Autumn
        System.out.println(str[1]); //打印 192.168.56.1
    }

    /**
     * 根据主机名称获取ip地址
     * @param otherName  主机名(可以是局域网中的机器名或者是域名)
     * @throws UnknownHostException
     */
    public static void getHostByName(String otherName) throws UnknownHostException {
        InetAddress otherHost = InetAddress.getByName(otherName);
        String hostName = otherHost.getHostName();
        String hostAddress = otherHost.getHostAddress();
        System.out.println(hostName); //打印 Lenovo-Autumn
        System.out.println(hostAddress); //打印 192.168.56.1
        System.out.println(otherHost);   //打印:Lenovo-Autumn/192.168.56.1
    }
}
