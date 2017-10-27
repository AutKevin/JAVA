/**
 * 项目名:WebProjectForWebService 
 * 包   名:com.qy.servletcontextlistener 
 * 文件名:contextlistener.java 
 */
package com.qy.servletcontextlistener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.xml.ws.Endpoint;

import com.qy.impl.WebService2Impl;

/**
 * 名   称：contextlistener.java
 * 描   述：
 * 作   者：邱  宇
 * 时   间：2017年10月27日
 * --------------------------------------------------
 * 修改历史
 * 序号    日期    修改人     修改原因 
 * 1                                                        
 * **************************************************
 */
//使用Servlet3.0提供的@WebListener注解将实现了ServletContextListener接口的WebServicePublishListener类标注为一个Listener
// @WebListener
public class contextlistener implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//必须要是部署机器的ip,端口也要开,我就用tomcat的端口了
		String address = "http://222.222.221.137:8087/WS_Server2/Webservices2";
		//用endpoint发布webservice
		Endpoint.publish(address, new WebService2Impl());
		System.out.println("通过servletcontextlistener部署webservice成功");
	}

}
