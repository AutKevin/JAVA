package com.qy.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CancleAutoLoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 移除session中的数据
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		// 移除cookie
		removeCookie(request, response);
		// 跳转到登录页面
		req.getRequestDispatcher("/Login.jsp").forward(request, response);
	}
	public void removeCookie(HttpServletRequest req, HttpServletResponse res) {
		// 创建一个相同名字的cookie
		Cookie cookie = new Cookie("autologin", "");
		// 有效期设置为0,命令浏览器删除该cookie
		cookie.setMaxAge(0);
		// 设置删除cookie的路径
		cookie.setPath(req.getContextPath());
		res.addCookie(cookie);
		System.out.println("cookie移除成功");
	}
}
