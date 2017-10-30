/**
 * 项目名:shebao_yzw 
 * 包   名:com.gmtx.shebao_yzw.tool 
 * 文件名:PropUtil.java 
 */
package com.gmtx.shebao_yzw.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

/**
 * 名   称：PropUtil.java
 * 描   述：
 * 作   者：邱  宇
 * 时   间：2017年10月30日
 * --------------------------------------------------
 * 修改历史
 * 序号    日期    修改人     修改原因 
 * 1                                                        
 * **************************************************
 */
public class PropUtil {
	private String fileName = null;
	private String propKey = null;
	private URL url = null;
	Properties properties = new Properties();
	
	/**
	 * 根据url实例化properties
	 * @param url
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public PropUtil(URL url) throws URISyntaxException, IOException {
		this.url = url;
		File file =new File(url.toURI());
		if (file!=null) {
			FileInputStream fis = new FileInputStream(file);
			properties.load(fis);
		}
	}

	/**
	 * 根据文件全路径实例化properties
	 * @param fileName
	 */
	public PropUtil(String fileName) {
		this.fileName = fileName;
		try {
			if (fileName!=null&&!fileName.isEmpty()) {
				InputStream is = new FileInputStream(fileName);
				properties.load(is);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 根据properties的key值获取value
	 * @param key
	 * @return
	 */
	public String getPro(String key) {
		String value = properties.getProperty(key);
		return value;
	}
	/**
	 * 根据配置文件的url和properties的key值获取value
	 * @param key
	 * @return
	 */
	public static String getPro(URL url,String key){
		Properties properties = new Properties();
		File file = null;
		try {
			file = new File(url.toURI());
			if (file!=null) {
				FileInputStream fis = new FileInputStream(file);
				properties.load(fis);
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(key,"该url未在webServiceURL.properties洪配置");
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getPropKey() {
		return propKey;
	}
	public void setPropKey(String propKey) {
		this.propKey = propKey;
	}
	public URL getUrl() {
		return url;
	}
	public void setUrl(URL url) {
		this.url = url;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
}
