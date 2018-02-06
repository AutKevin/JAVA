package com.qy.picupload;

import java.io.*;
import java.net.Socket;
import java.util.Random;

/**
 * Created by Autumn on 2018/2/5.
 */
public class Upload implements Runnable {
    private Socket socket;

    public Upload(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
