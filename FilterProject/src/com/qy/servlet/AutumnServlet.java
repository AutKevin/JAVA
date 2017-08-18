/**
 * 项目名:FilterProject 
 * 包   名:com.qy.servlet 
 * 文件名:AutumnServlet.java 
 */
package com.qy.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 名   称：AutumnServlet.java
 * 描   述：
 * 作   者：邱  宇
 * 时   间：2017年8月15日
 * --------------------------------------------------
 * 修改历史
 * 序号    日期    修改人     修改原因 
 * 1                                                        
 * **************************************************
 */
public class AutumnServlet extends HttpServlet{
	ServletConfig config = null;

	public AutumnServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String oldEncode=req.getCharacterEncoding();
		System.out.println("getEncode:   "+oldEncode);
		String characterEncode=config.getInitParameter("characterEncode");
		System.out.println(characterEncode);
		String s = req.getParameter("username");
		System.out.println("参数为:   "+s);
		String string = new String(s.getBytes("ISO-8859-1"),"utf-8");
		System.out.println("转码后的参数为:   "+string);
		resp.getOutputStream().write(s.getBytes());
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String oldEncode=req.getCharacterEncoding();
		System.out.println("postEncode:  "+oldEncode);
		String characterEncode=config.getInitParameter("characterEncode");
		System.out.println(characterEncode);
		String s = req.getParameter("username");
		System.out.println("参数为:   "+s);
		String string = new String(s.getBytes("ISO-8859-1"),"utf-8");
		System.out.println("转码后的参数为:   "+string);
		resp.getOutputStream().write(s.getBytes());
	}
	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

}
