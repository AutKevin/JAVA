package com.qy;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class RestFul_HttpClient {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		getMessage("http://127.0.0.1:8080/RESTful/rest/userService/hello","zt");
		getMessage("http://127.0.0.1:8080/RESTful/rest/userService/bye","qy");
	}

	public static void getMessage(String path,String param) throws ClientProtocolException, IOException {
		path=path+"/"+param;  
        //1.创建客户端访问服务器的httpclient对象   打开浏览器  
        HttpClient httpclient=new DefaultHttpClient();  
        //2.以请求的连接地址创建get请求对象     浏览器中输入网址  
        HttpGet httpget=new HttpGet(path);  
        httpget.setHeader("Accept", "");
        //3.向服务器端发送请求 并且获取响应对象  浏览器中输入网址点击回车  
        HttpResponse response=httpclient.execute(httpget);  
        //4.获取响应对象中的响应码  
        StatusLine statusLine=response.getStatusLine();//获取请求对象中的响应行对象
        System.out.println("Response status: " + response.getStatusLine());   //打印响应状态
        int responseCode=statusLine.getStatusCode();//从状态行中获取状态码  
        if(responseCode==200){  
            //5.获取HttpEntity消息载体对象  可以接收和发送消息  
            HttpEntity entity=response.getEntity();  
            // 打印响应内容长度    
            System.out.println("Response content length: " + entity.getContentLength());
            //EntityUtils中的toString()方法转换服务器的响应数据  
            String str=EntityUtils.toString(entity, "utf-8");  
            System.out.println("Response content:"+str);  
            
            //6.从消息载体对象中获取操作的读取流对象  
            /*InputStream input=entity.getContent();  
            BufferedReader br=new BufferedReader(new InputStreamReader(input));  
            String str1=br.readLine();  
            String result=new String(str1.getBytes("gbk"), "utf-8");  
            System.out.println("服务器的响应是:"+result);  
            br.close();  
            input.close();  */
        }else{  
            System.out.println("响应失败!");  
        }  
    }  
}
