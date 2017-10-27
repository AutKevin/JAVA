package com.qy.servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.xml.ws.Endpoint;

import com.qy.impl.WebService2Impl;
import com.qy.impl.WebServiceImpl;

/**
 * 项目名:WebService 
 * 包   名: 
 * 文件名:TestServlet.java 
 */

/**
 * 名   称：TestServlet.java
 * 描   述：用于发布webservice的servlet
 * 作   者：邱  宇
 * 时   间：2017年10月27日
 * --------------------------------------------------
 * 修改历史
 * 序号    日期    修改人     修改原因 
 * 1                                                        
 * **************************************************
 */

//使用Servlet3.0提供的@WebServlet注解将继承HttpServlet类的普通Java类标注为一个Servlet
//将value属性设置为空字符串，这样WebServicePublishServlet就不提供对外访问的路径
//loadOnStartup属性设置WebServicePublishServlet的初始化时机
//@WebServlet(value="",loadOnStartup=0)
public class TestServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		//必须要是部署机器的ip,端口也要开,我就用tomcat的端口了
		String address = "http://222.222.221.137:8088/WS_Server/Webservicesss";
		//用endpoint发布webservice
		Endpoint.publish(address, new WebServiceImpl());
		System.out.println("通过httpservlet部署webservice成功");
	}
	
}
