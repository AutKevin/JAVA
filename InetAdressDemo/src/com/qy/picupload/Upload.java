package com.qy.picupload;

import java.io.*;
import java.net.Socket;
import java.util.Random;

/**
 * TCP图片上传服务器
 *  1.ServerSocket套接字对象,监听8000
 *      ServerSocket serverSocket = ServerSocket(int port);
 *  2.方法accept()获取客户端的连接对象
 *      Socket socket = serverSocket.accept();
 *  3.客户端连接对象获取字节输入流,读取客户端发送图片
 *      InputStream in = socket.getInputStream();
 *  4.创建File对象,绑定上传文件夹。判断文件夹存在,不存在则创建文件夹
 *      File upload = new File("d:\\upload");
 *      if (!upload.exists()){
 *         upload.mkdirs();
 *      }
 *  5.创建字节输出流,数据目的File对象所在文件夹
 *      String fileName = "pic"+System.currentTimeMillis()+ new Random().nextInt(9999)+".jpg";
 *      FileOutputStream fos = new FileOutputStream(upload+File.separator+fileName);
 *  6.字节流读取图片,字节流将图片写入到目的文件中
 *      byte[] bytes = new byte[1024];
 *      int len = 0;
 *      while((len = in.read(bytes))!=-1){    //读的是客户端发过来图片的字节数组,只有读文件能读到1,所以永远读不到-1
 *          fos.write(bytes,0,len);
 *      }
 *  7.将上传成功回写给客户端
 *      socket.getOutputStream().write(("上传到服务器"+socket.getLocalAddress().toString()+"成功").getBytes());
 *  8.关闭资源
 *      fos.close();
 *      socket.close();
 *  Created by Autumn on 2018/2/5.
 */
public class Upload implements Runnable {
    private Socket socket;

    public Upload(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            //获取输入流
            InputStream in = socket.getInputStream();
            //创建文件夹
            File upload = new File("d:\\upload");
            if (!upload.exists()){
                upload.mkdirs();
            }
            String fileName = "pic"+System.currentTimeMillis()+ new Random().nextInt(9999)+".jpg";
            //创建字节输出流,将图片写入到目的文件夹       upload:d://upload
            FileOutputStream fos = new FileOutputStream(upload+File.separator+fileName);
            //读写字节数组
            byte[] bytes = new byte[1024];
            int len = 0;
            while((len = in.read(bytes))!=-1){    //读的是客户端发过来图片的字节数组,只有读文件能读到1,所以永远读不到-1
                fos.write(bytes,0,len);
            }
            System.out.println("成功接收来自"+socket.getInetAddress()+socket.getPort()+"的图片!");
            //通过客户端连接对象获取字节输出流
            //上传成功写会客户端
            socket.getOutputStream().write(("上传到服务器"+socket.getLocalAddress().toString()+"成功").getBytes());
            fos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
