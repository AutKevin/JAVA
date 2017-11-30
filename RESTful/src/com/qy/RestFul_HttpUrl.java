package com.qy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class RestFul_HttpUrl {
	
	public static final String BASE_URI = "http://127.0.0.1:8080/RESTful";
	public static final String PATH_Hello = "/userService/hello/";
	public static final String PATH_Bye = "/userService/bye/";
	
	public static void main(String[] args) throws IOException {
		String result1 = sendPostByUrl(BASE_URI+"/rest"+PATH_Hello+"qy","get",null);
		System.out.println(result1);
	}

	/**
	 * @param path    请求路径
	 * @param method    请求方法
	 * @param params    参数
	 * @return
	 * @throws IOException
	 */
	public static String sendPostByUrl(String path,String method,String params) throws IOException{
		BufferedReader in=null;
		java.net.HttpURLConnection conn=null;
		String msg = "";// 保存调用http服务后的响应信息
		try{
			java.net.URL url = new java.net.URL(path);
			conn = (java.net.HttpURLConnection) url.openConnection();
			conn.setRequestMethod(method.toUpperCase());//请求的方法get,post,put,delete
			conn.setConnectTimeout(5 * 1000);// 设置连接超时时间为5秒 
			conn.setReadTimeout(20 * 1000);// 设置读取超时时间为20秒 
			conn.setDoOutput(true);// 使用 URL 连接进行输出，则将 DoOutput标志设置为 true
			
			conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
			//conn.setRequestProperty("Content-Encoding","gzip");
			conn.setRequestProperty("Content-Length", String.valueOf(params==null?"":params.length()));
			if (params!=null&&!params.isEmpty()) {
				OutputStream outStream = conn.getOutputStream();// 返回写入到此连接的输出流
				outStream.write(params.getBytes());
				outStream.close();//关闭流
			}
			if (conn.getResponseCode() == 200) {
			    // HTTP服务端返回的编码是UTF-8,故必须设置为UTF-8,保持编码统一,否则会出现中文乱码
			    in = new BufferedReader(new InputStreamReader(
			            (InputStream) conn.getInputStream(), "UTF-8"));
			    msg = in.readLine();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(null!=in)
			{
				in.close();
			}
			if(null!=conn)
			{
				conn.disconnect();
			}
		}
		return msg;
	}
}
