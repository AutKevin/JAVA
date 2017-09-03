package com.qy.listener;

import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author Autumn
 * 统计当前用户在线个数
 */
public class OnLineCountListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis())+se.getSession().getId()+"session被创建了");
		ServletContext context = se.getSession().getServletContext();
		Integer totalCount = (Integer) context.getAttribute("onlineNum");
		if (totalCount==null) {
			context.setAttribute("onlineNum", 1);
		}else{
			totalCount++;
			context.setAttribute("onlineNum", totalCount);
			System.out.println("目前"+totalCount+"人");
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis())+se.getSession().getId()+"session被销毁");
		ServletContext context = se.getSession().getServletContext();
		Integer totalCount = (Integer) context.getAttribute("onlineNum");
		if(totalCount==null){
			context.setAttribute("onlineNum", 1);
		}else{
			totalCount--;
			context.setAttribute("onlineNum", totalCount);
			System.out.println("目前"+totalCount+"人");
		}
	}

}
