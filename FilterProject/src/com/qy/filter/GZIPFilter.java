/**
 * 项目名:FilterProject 
 * 包   名:com.qy.filter 
 * 文件名:GZIPFilter.java 
 */
package com.qy.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * 名 称：GZIPFilter.java 描 述： 作 者：邱 宇 时 间：2017年8月16日
 * -------------------------------------------------- 修改历史 序号 日期 修改人 修改原因 1
 * **************************************************
 */
public class GZIPFilter implements Filter {
	//将向浏览器输出的内容加入到内存
    private Map<String, byte[]> mapContent = new HashMap<String, byte[]>();
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain filterChain) throws IOException, ServletException {
		System.out.println("<-----------------------GZIPFilter过滤器开始");
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		//1.得到用户请求的uri
		String uri = request.getRequestURI();
		//重写response的getoutputstream,重写outputstream的write方法
		BufferResponse bufferResponse = new BufferResponse(response);
		filterChain.doFilter(request, bufferResponse);
        //向浏览器输出的方法被改写,只是存入了bufferresponse中的字段中.
		byte[] out=bufferResponse.getBuffer();
		//2.获取uri
		byte[] mapValue = mapContent.get(uri);
		//3.向内存中判断并加入
		if (mapValue!=null) {
			String temp = new String(mapValue, res.getCharacterEncoding());
			System.out.println("内存中已存在"+temp);
		}else if (mapValue==null) {
			mapContent.put(uri, out);
			String temp = new String(out, res.getCharacterEncoding());
			System.out.println("uri已保存到内存中"+uri+":"+temp);
		}
		System.out.println("filter压缩前为"+out.length);
		System.out.println("filter压缩前的字符为"+new String(out,response.getCharacterEncoding()));
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		GZIPOutputStream gout = new GZIPOutputStream(bout);
		gout.write(out);
		gout.close();
		byte[] rout=bout.toByteArray();
		System.out.println("filter压缩之后为"+rout.length);
		System.out.println("filter压缩之后字符串为"+new String(rout,response.getCharacterEncoding()));
		System.out.println("----------------------GZIPFilter过滤器结束");
		response.setHeader("content-encoding", "gzip");
		response.setContentLength(rout.length);
		response.getOutputStream().write(rout);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	class BufferResponse extends HttpServletResponseWrapper {
		HttpServletResponse response = null;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		PrintWriter pw = null;

		public BufferResponse(HttpServletResponse response) {
			super(response);
			this.response = response;
		}

		@Override
		public ServletOutputStream getOutputStream() throws IOException {
			return new MyServletOutputStream(bout);
		}

		@Override
		public PrintWriter getWriter() throws IOException {
			return new PrintWriter(new OutputStreamWriter(bout,response.getCharacterEncoding()));
		}
		
		public byte[] getBuffer() {
			if (pw!=null) {
				pw.close();
			}
			if (bout!=null) {
				try {
					bout.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return bout.toByteArray();
			}
			return null;
		}
	}

	class MyServletOutputStream extends ServletOutputStream {
		ByteArrayOutputStream bout = null;

		public MyServletOutputStream(ByteArrayOutputStream bout) {
			this.bout = bout;
		}

		//MyServletOutputStream--->ServletOutputStream---->OutputStream
		//猜测,ServletOutPutStream只是重写了write(int b)方法,write(byte[] bt)会调用write(int b)
		@Override
		public void write(int b) throws IOException {//这个方法会被调用多次用来写数据的byte流
			this.bout.write(b);  //这里ByteArrayOutputStream只调用了这个方法,并没有其他的方法
		}

		@Override
		public boolean isReady() { return false; }

		@Override
		public void setWriteListener(WriteListener arg0) { }

	}
}
