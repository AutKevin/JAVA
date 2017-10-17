package com.qy.zip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
public class FileText {
    static String sourcePathString = "D:\\Programmer_QY\\apache-tomcat-7.0.78\\webapps\\ShebaoProtocol\\declare_attached\\814379857\\glgzzd\\changelog.txt";
    static String targetPathString ="D:\\Users\\Autumn\\Downloads\\123.txt";
	public static void main(String[] args) throws IOException {
		System.out.println("开始读取");
		File sourceFile = new File(sourcePathString);
		if (sourceFile == null) {
			System.out.println("文件不存在");
			return;
		}
		FileInputStream fis = new FileInputStream(sourceFile);
		BufferedInputStream bis = new BufferedInputStream(fis);
		File targeFile = new File(targetPathString);
		FileOutputStream fos = new FileOutputStream(targeFile);
		BufferedOutputStream bos = new BufferedOutputStream(fos);

		//byte[] temp = new byte[1024];
		int len;
		while ((len = bis.read()) != -1) {
			//bos.write(temp, 0, len);
			bos.write(len);
		}
		System.out.println("读取完成");
		bos.close();
		fos.close();
		bis.close();
		fis.close();
		
		/*File targeFile = new File("D:\\Users\\Autumn\\Downloads\\秋.jpeg");
		FileOutputStream fos = new FileOutputStream(targeFile);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		toOutStream("D:\\Programmer_QY\\apache-tomcat-7.0.78\\webapps\\ShebaoProtocol\\declare_attached\\814379857\\glgzzd\\秋.jpeg", bos);
		bos.close();
		fos.close();*/
	}
	
	public static void toOutStream(String sourceFile,OutputStream bos) throws IOException{
		 //读取目标文件,将文件写入到指定文件中
        FileInputStream fis = new FileInputStream(sourceFile);
        BufferedInputStream bis = new BufferedInputStream(fis);
        
        int tag;
        System.out.println(sourceFile);
        //将源文件写入到zip文件中
        while((tag=bis.read())!=-1)
        {
            bos.write(tag);
        }
        bos.flush();
        bis.close();
        fis.close();
	}
}
