package com.autumn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.config.AlipayConfig;

public class Pay extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Pay() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取要向支付宝支付的参数,由页面传过来
		//商户订单号，商户网站订单系统中唯一订单号，必填
		String out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		//付款金额，必填
		String total_amount = new String(request.getParameter("WIDtotal_amount").getBytes("ISO-8859-1"),"UTF-8");
		//订单名称，必填
		String subject = new String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"),"UTF-8");
		//商品描述，可空
		String body = new String(request.getParameter("WIDbody").getBytes("ISO-8859-1"),"UTF-8");
		
		
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
		
		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);  //设置同步回调通知
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);  //设置异步回调通知
		
		//设置支付参数
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
				+ "\"total_amount\":\""+ total_amount +"\"," 
				+ "\"subject\":\""+ subject +"\"," 
				+ "\"body\":\""+ body +"\"," 
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		
		//若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
		//alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
		//		+ "\"total_amount\":\""+ total_amount +"\"," 
		//		+ "\"subject\":\""+ subject +"\"," 
		//		+ "\"body\":\""+ body +"\"," 
		//		+ "\"timeout_express\":\"10m\"," 
		//		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		//请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节
		
		//请求
		String result = null;
		try {
			result = alipayClient.pageExecute(alipayRequest).getBody();
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//输出
		/*打印的是支付宝付款码页面<form name="punchout_form" method="post" action="https://openapi.alipaydev.com/gateway.do?sign=NM7Zk33PH6W%2BFxkXVMfcg4ZeTVas3YS5aJoktIiZZOLv1hO4o23yHQvSW%2BTRt5RJCMJFcX0V%2BJQPoHwznZDA31ZywODBfqTjhsHaBenpbmxVOXjKSJE0ODI8Wf39d2AMDRThIJT6m4FtGYvbHMAgHeDLhX0X5HYgg5mGzZJLYAXbcgBKJioULyEX5Yfn%2Bd7twx8F01pJWsfeCFWkQNd46GetzQ83HivXDEmHXEbV3N47gjgJYBSlptLhK%2Bj9d8QTzvYJ6el2eO2fLbjHepWJ%2BULcc55XXSpq5RIJJYXCZKOzxllEwpAWD%2FAPE4RZxHjUQ80C%2BIf5p%2Fz1Jk%2FIxh7axg%3D%3D&timestamp=2018-07-06+10%3A17%3A37&sign_type=RSA2&notify_url=http%3A%2F%2Flocalhost%3A80%2FAlipay%2Fnotify_url.jsp&charset=utf-8&app_id=2016080500172104&method=alipay.trade.page.pay&return_url=http%3A%2F%2Flocalhost%3A80%2FAlipay%2Freturn_url.jsp&version=1.0&alipay_sdk=alipay-sdk-java-dynamicVersionNo&format=json">
			<input type="hidden" name="biz_content" value="{&quot;out_trade_no&quot;:&quot;201876101732228&quot;,&quot;total_amount&quot;:&quot;1000&quot;,&quot;subject&quot;:&quot;测试&quot;,&quot;body&quot;:&quot;&quot;,&quot;product_code&quot;:&quot;FAST_INSTANT_TRADE_PAY&quot;}">
			<input type="submit" value="立即支付" style="display:none" >
			</form>
			<script>document.forms[0].submit();</script>*/
		response.resetBuffer();
		response.setContentType("text/html;charset=UTF-8");
		response.getOutputStream().write(result.toString().getBytes("utf-8"));
		response.getOutputStream().flush();
		//response.getWriter().println(result);
		//response.getWriter().flush();
	}

	public void init() throws ServletException {
	}

}
