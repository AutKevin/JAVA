package com.qy.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

import org.apache.catalina.connector.Request;

import sun.misc.CharacterEncoder;

public class EncodeFilter implements Filter {
    FilterConfig config = null;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain filterChain) throws IOException, ServletException {
		System.out.println("<--------------------EncoderFilter(编码,html转义,违禁字过滤)拦截器开始");
		HttpServletRequest reqs = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse) res;
		String encode =config.getInitParameter("encode");//配置的编码
		System.out.println("配置的编码格式为"+encode);
		req.setCharacterEncoding(encode);
		res.setCharacterEncoding(encode);
		res.setContentType("text/html;charset="+encode);
		String oldEncode=req.getCharacterEncoding();//原本的编码
		System.out.println("request的原始编码为   "+oldEncode);
		String username = req.getParameter("username");//页面传过来的数据
		//单纯的filter只能改变req的一些属性,例如req的编码格式.
		//如果要改变方法,则要使用detector设计模式,对原对象进行包装.
		CharacterEncoderRequest creq = new CharacterEncoderRequest(reqs);//字体编码包装类
		DirtyWord dwq= new DirtyWord(creq);//违禁字包装类
		System.out.println("EncoderFilter(编码,html转义,违禁字过滤)结束------------------------>");
		filterChain.doFilter(dwq, res);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config=config;
	}

}

/**
 * 名   称：EncodeFilter.java
 * 描   述：内部类(request的包装),detector设计模式(wrapper设计模式),
 * 在这里一个一个包装类实现了两个功能
 * 作   者：邱  宇
 * 时   间：2017年8月16日
 * --------------------------------------------------
 * 修改历史
 * 序号    日期    修改人     修改原因 
 * 1                                                        
 * **************************************************
 */
class CharacterEncoderRequest extends HttpServletRequestWrapper{
	HttpServletRequest request = null;
	
	public CharacterEncoderRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	@Override
	public String getParameter(String name) {
		System.out.println("*****filter转码");
		String value=request.getParameter(name);
		if (value==null) {
			return null;
		}
		if (request.getMethod().equalsIgnoreCase("get")) {
			try {
				String utf8value=new String(value.getBytes("iso-8859-1"),"utf-8");
				System.out.println("utf8value的值为"+utf8value);
				return htmlFilter(value);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}else if (request.getMethod().equalsIgnoreCase("post")) {
			return htmlFilter(value);
		}
		return htmlFilter(value);
	}
	//当传过来的是script的字符串时,为了返回到页面不当做script处理.通过转义实现.
	public String htmlFilter(String value){
		System.out.println("*****html转义过滤");
		if (value==null) {
			return null;
		}
		StringBuffer stringBuffer = new StringBuffer(value.length()*2);
		for (int i = 0; i < value.length(); i++) {
			switch (value.charAt(i)) {
			case '<': stringBuffer.append("&lt;");
				break;
			case '>': stringBuffer.append("&gt;");
			break;
			case '"': stringBuffer.append("&quot;");
			break;
			case '&': stringBuffer.append("&amp;");
			break;
			default: stringBuffer.append(value.charAt(i));
				break;
			}	
		}
		return stringBuffer.toString();
	}
}

/*class DirtyWord extends HttpServletRequestWrapper{
    private HttpServletRequest request = null;
	public DirtyWord(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
}*/

