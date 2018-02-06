package com.qy.picupload;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多线程接收图片
 * Created by Autumn on 2018/2/5.
 */
public class TCPThreadServer {
    public static void main(String[] args) throws IOException {
        //服务端不用指定ip地址,只需指定端口号
        ServerSocket serverSocket = new ServerSocket(8000);
        while(true){
            //获得一个客户端Socket对象,开启一个线程
            Socket socket = serverSocket.accept();   //线程阻塞
            new Thread(new Upload(socket)).start();
        }
    }
}
