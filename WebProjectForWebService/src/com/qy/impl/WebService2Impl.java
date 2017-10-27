/**
 * 项目名:WebService 
 * 包   名:com.qy.impl 
 * 文件名:WebServiceImpl.java 
 */
package com.qy.impl;

import javax.jws.WebService;

import com.qy.inf.Webservice2I;
import com.qy.inf.WebserviceI;

/**
 * 名   称：WebServiceImpl.java
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
public class WebService2Impl implements Webservice2I {
	
	@Override
	public String run(String name) {
		String result = "not flash , but have to run."+name;
		System.out.println(result);
		return result;
	}
	
	@Override
	public String lover(String name) {
		String result = "dyl,"+name;
		System.out.println(result);
		return result;
	}
}
