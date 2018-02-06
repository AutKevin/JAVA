package com.qy.picupload;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Autumn on 2018/2/5.
 */
public class TCPThreadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        while(true){
            //获得一个客户端对象,开启一个线程
            Socket socket = serverSocket.accept();
            new Thread(new Upload(socket)).start();
        }
    }
}
