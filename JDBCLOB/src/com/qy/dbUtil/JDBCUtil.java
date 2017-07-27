package com.qy.dbUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JDBCUtil {
	private static String driver=null;
	private static String url=null;
	private static String username=null;
	private static String password=null;
	
	static{
		try {
			//class.getClassLoader().getResourceAsStream()是以编译后的class文件夹为根目录,
			//class.getResourceAsStream()是以编译后的类为根目录
			InputStream is= JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");  
			Properties properties = new Properties();
			properties.load(is);
			driver = properties.getProperty("driver").toString();
			url= properties.get("url").toString();
			username= properties.get("username").toString();
			password= properties.get("password").toString();
			Class.forName(driver);
		} catch (IOException e) {
			System.out.println("db.properties文件流加载失败");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("com.mysql.jdbc.Driver加载类不存在");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("JDBC链接成功");
			return con;
	}
	
	/**
	 * @param con
	 * @param st
	 * @param rs
	 */
	public static void release(Connection con,Statement st,ResultSet rs) {
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("ResultSet关闭异常");
				e.printStackTrace();
			}
		}
		
		if (st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				System.out.println("Statement关闭异常");
				e.printStackTrace();
			}
		}
		
		if (con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Connection关闭异常");
				e.printStackTrace();
			}
		}
		System.out.println("关闭成功");
	}
	
	
	
	
	public static void main(String[] args) {
		try {
			Connection con = getConnection();
			release(con, null, null);
		} catch (SQLException e) {
			System.out.println("Connection连接异常");
			e.printStackTrace();
		}
	}
}
