package com.qy.publish;

import javax.xml.ws.Endpoint;

import com.qy.impl.WebServiceImpl;

public class text {

	public static void main(String[] args) {
		//必须要是部署机器的ip,端口也要开,我就用tomcat的端口了
		String address = "http://222.222.221.137:8080/WS_Server/Webservice";
		//用endpoint发布webservice
		Endpoint.publish(address, new WebServiceImpl());
		System.out.println("通过java文件部署webservice成功");
	}

}
