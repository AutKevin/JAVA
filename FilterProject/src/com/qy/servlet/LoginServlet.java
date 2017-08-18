package com.qy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RespectBinding;

import com.qy.dao.UserDao;
import com.qy.entity.User;

public class LoginServlet extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String uname=req.getParameter("username");
		String pass=req.getParameter("password");
		UserDao dao = new UserDao();
		User user = dao.find(uname, pass);
		if (user==null) {
			req.getRequestDispatcher("/Message.jsp").forward(req, resp);
			return;
		}else{
			req.getSession().setAttribute("user", user);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
	}
    
	private void sendAutoCookie(HttpServletRequest req,HttpServletResponse res,User user) {
		Cookie cookie = new Cookie("autologin", user.getUsername()+"."+user.getPassword());
		cookie.setMaxAge((int) (System.currentTimeMillis()+4*3600*1000));
		cookie.setPath(req.getContextPath());
		res.addCookie(cookie);
		System.out.println("向服务器添加cookie成功");
	}
}
