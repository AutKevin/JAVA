package com.qy.picupload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * TCP图片上传服务器
 *  1.ServerSocket套接字对象,监听8000
 *  2.方法accept()获取客户端的连接对象
 *  3.客户端连接对象获取字节输入流,读取客户端发送图片
 *  4.创建File对象,绑定上传文件夹
 *      判断文件夹存在,不存在则创建文件夹
 *  5.创建字节输出流,数据目的File对象所在文件夹
 *  6.字节流读取图片,字节流将图片写入到目的文件中
 *  7.将上传成功回写给客户端
 *  8.关闭资源
 * Created by Autumn on 2018/2/5.
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8000);
        Socket socket = server.accept();
        InputStream in = socket.getInputStream();
        //创建文件夹
        File upload = new File("d:\\upload");
        if (!upload.exists()){
            upload.mkdirs();
        }
        String fileName = "pic"+System.currentTimeMillis()+ new Random().nextInt(9999)+".jpg";
        //创建字节输出流,将图片写入到目的文件夹中       upload:d://upload
        FileOutputStream fos = new FileOutputStream(upload+File.separator+fileName);
        //读写字节数组
        byte[] bytes = new byte[1024];
        int len = 0;
        while((len = in.read(bytes))!=-1){    //读的是客户端发过来图片的字节数组,只有读文件能读到1,所以永远读不到-1
            fos.write(bytes,0,len);
        }
        //通过客户端连接对象获取字节输出流
        //上传成功写会客户端
        socket.getOutputStream().write("上传成功".getBytes());
        fos.close();
        socket.close();
        server.close();
    }
}
