package com.qy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * 调用接口
 */
public class HelloRestFulClient {
	public static final String BASE_URI = "http://127.0.0.1:8080/RESTful";
	public static final String PATH_Hello = "/userService/hello/";
	public static final String PATH_Bye = "/userService/bye/";
	//参数
	static String paramName = "qy";
	 
	public static void main(String[] args) throws IOException, URISyntaxException {

		/*//创建请求对象
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource resource = client.resource(BASE_URI);    //具体项目的WebResource
		//路径
		WebResource helloResource = resource.path("rest").path(PATH_Hello + paramName);  
		System.out.println("Client Response 返回状态");
		getClientResponse(helloResource);
		System.out.println("Response 返回 xml" );
		getResponse(helloResource);
		System.out.println("----------------------------------------------------");
		WebResource byeResource = resource.path("rest").path(PATH_Bye + paramName);
		System.out.println("Client Response 返回状态");
		getClientResponse(byeResource);
		System.out.println("Response 返回 xml" );
		getResponse(byeResource);*/
	}
	
	/**
	* 调用WebResource,返回客户端请求状态。
	* GET http://localhost:8080/RESTful/rest/userService/hello/qiuyu
	* 返回请求结果状态“200 OK”。
	*/
	private static String getClientResponse(WebResource resource) {
		String clientResponseString = resource.accept(MediaType.TEXT_XML)
									.get(ClientResponse.class).toString();
		System.out.println(clientResponseString);
		return clientResponseString;
	}
	 
	/**
	* 调用WebResource,返回请求结果XML
	* <root><Say>bye qiuyu</Say></root>
	*/
	private static String getResponse(WebResource resource) {
		String responseString = resource.accept(MediaType.TEXT_XML)
								.get(String.class);
		System.out.println(responseString);
		return responseString;
	}
	
}
