package com.qy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//这里@Path定义了类的层次路径。 
//指定了资源类提供服务的URI路径。
@Path("userService")
public class HelloRestFul {
	private String name= "";
	
	@GET    //get请求
	@Path("/hello/{name}")    //指定了资源类提供服务的URI路径。
	@Produces(MediaType.TEXT_XML)    //返回xml类型
	public String sayHello(@PathParam("name") String name){
		this.name = name;
		System.out.println("Hello "+this.name);
		return "<root>" + "<Say>" + "Hello "+name + "</Say>" + "</root>";
	}
	
	@GET
	@Path("/bye/{name}")
	@Produces(MediaType.TEXT_XML)
	public String bye(@PathParam("name") String name) {
		System.out.println("Bye "+ name);
		return "<root>" + "<Say>" + "bye "+name + "</Say>" + "</root>";
	}
}
