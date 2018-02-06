package com.qy.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP服务器程序
 * 表示服务器程序的类java.net.ServerSocket
 * 构造方法:
 *      ServerSocket(int port);   传递端口号
 *
 * Important:必须获得客户端的套接字(Socket)
 *     方法:Socket accept()
 *     服务器可以获取到客户端的套接字
 * Created by Autumn on 2018/2/5.
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        //调用服务器套接字对象accept()获取客户端套接字,具有线程等待效果
        Socket socket = serverSocket.accept();
        //根据获得的客户端的socket获取输入流
        InputStream inputStream = socket.getInputStream();
        //根据输入流将数据读入到data中
        byte[] data = new byte[1024];
        int len = inputStream.read(data);
        System.out.println(new String(data,0,len));

        //向客户端返回数据
        OutputStream os = socket.getOutputStream();
        os.write("这是一条服务器发送的数据".getBytes());

        socket.close();
        serverSocket.close();
    }
}
