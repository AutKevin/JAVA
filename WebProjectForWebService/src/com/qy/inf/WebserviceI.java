/**
 * 项目名:WebService 
 * 包   名:com.qy.inf 
 * 文件名:WebserviceI.java 
 */
package com.qy.inf;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * 名   称：WebserviceI.java
 * 描   述：
 * 作   者：邱  宇
 * 时   间：2017年10月27日
 * --------------------------------------------------
 * 修改历史
 * 序号    日期    修改人     修改原因 
 * 1                                                        
 * **************************************************
 */
@WebService
public interface WebserviceI {
	@WebMethod
	public String sayHello(String name);
	@WebMethod
	public String sayBye(String name);
}
