package com.qy.picupload;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;

/**
 * 实现TCP图片上传客户端
 * 实现步骤:
 *      1.Socket套接字连接服务器,指定ip和端口
 *          Socket socket = Socket(String host, int port);
 *      2.通过Socket获取字节输出流,写图片
 *          OutputStream os = socket.getOutputStream();
 *      3.使用自己的流对象,读取图片数据源
 *          FileInputStream fis = new FileInputStream(filePath);
 *      4.读取图片,使用字节输出流,将图片写到服务器,采用字节数组进行缓冲
 *           int len = 0;
 *           byte[] bytes = new byte[1024];
 *           while ((len = fis.read(bytes)) != -1){
 *              os.write(bytes,0,len);
 *           }
 *      5.通过Socket套接字获取字节输入流,读取服务器发回来的上传成功
 *          InputStream inputStream = socket.getInputStream();
 *          len = inputStream.read(bytes);
 *          System.out.println("服务器返回："+new String(bytes,0,len));
 *      6.关闭资源
 *          socket.close();
 *
 *      Created by Autumn on 2018/2/5.
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        String ip = "127.0.0.1";
        int port = 8000;
        File fileFolder = new File("D:\\Users\\Autumn\\Pictures");

        uploadPic(ip,port,fileFolder+File.separator+"tiger.jpg");
        uploadPic(ip,port,fileFolder+File.separator+"water.jpg");
        uploadPic(ip,port,fileFolder+File.separator+"sunset.jpg");
    }

    /**
     * 上传图片
     * @param ip  服务器ip地址
     * @param port   服务器端口号
     * @param filePath   文件路径
     * @throws IOException
     */
    public static void uploadPic(String ip,int port,String filePath) throws IOException{
        //创建客户端Socket
        Socket socket = new Socket(ip,port);
        //根据Socket获取字节输出流,用此流将图片写到服务器
        OutputStream os = socket.getOutputStream();

        //创建字节输入流,读取本机上的数据源图片
        FileInputStream fis = new FileInputStream(filePath);

        //开始读写字节数组,从输入流中读取到输出流
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1){
            os.write(bytes,0,len);
        }
        //文件读完时给服务器写终止序列
        socket.shutdownOutput();

        //获取字节输入流,读取服务器的上传成功
        InputStream inputStream = socket.getInputStream();
        len = inputStream.read(bytes);
        System.out.println("服务器返回："+new String(bytes,0,len));

        socket.close();
    }
}
