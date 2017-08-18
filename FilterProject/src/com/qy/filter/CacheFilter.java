package com.qy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CacheFilter implements Filter {
	FilterConfig filterConfig = null;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
        this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
        System.out.println("<-----------------------CacheFilter过滤器开始");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		//1.获取用户想访问的资源
		String uri=req.getRequestURI();
		//2.得到用户想访问的资源的后缀名
		String ext = uri.substring(uri.lastIndexOf(".")+1);
		//得到资源需要缓存的时间
		String time = filterConfig.getInitParameter(ext);
		if (time!=null) {
			long longtime = Long.parseLong(time)*3600*1000;
			long resuttile =System.currentTimeMillis()+longtime;
			System.out.println(ext+"被缓存到"+resuttile+"毫秒"+"总共"+time+"小时");
			//3.设置缓存时间
			res.setDateHeader("expires", resuttile);
		}
		System.out.println("------------------------CacheFilter过滤器结束");
		//禁止浏览器缓存
		/*res.addDateHeader("Expires", -1);
		res.setHeader("Cache-Control", "no-cache");
		res.setHeader("Pragma", "no-cache");*/
		chain.doFilter(req, res);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
