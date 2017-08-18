package com.qy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qy.dao.UserDao;
import com.qy.entity.User;

public class AutoLoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// 如果正在使用,直接从session中获取
		if (req.getSession().getAttribute("user") != null) {
			chain.doFilter(req, res);
		}
		//1.从cookies数组中找到对应cooke指定的值
		String valueString = null;
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("autologin")) {
					valueString=cookies[i].getValue();
				}
			}
		}
		
		if (valueString!=null) {
			String name =valueString.split(".")[0];
			String pass = valueString.split(".")[1];
			UserDao dao = new UserDao();
			User user=dao.find(name, pass);
			System.out.println("从cookie中读取到用户名为"+name+"密码为"+pass);
			req.getSession().setAttribute("user", user);//将从cookie中读到的cookie放入session中
		}
        chain.doFilter(req, res);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
