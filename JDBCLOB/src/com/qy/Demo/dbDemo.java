package com.qy.Demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qy.dbUtil.JDBCUtil;

public class dbDemo {
	
	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	Reader reader = null;
	
	/**
	 * 将clob写入数据库
	 */
	public void write(){
		try {
			//获取链接
			con = JDBCUtil.getConnection();
			String sqlString = "insert into lobtable(id,resum,clob) values('1',null,?)";
			st = con.prepareStatement(sqlString);
			//这种方式获取的路径，其中的空格会被使用“%20”代替
			String txtPath = dbDemo.class.getClassLoader().getResource("clobdata.txt").getPath();
			txtPath = txtPath.replaceAll("%20", " ");
			System.out.println(txtPath);
			File file = new File(txtPath);
			reader = new FileReader(txtPath);
			st.setCharacterStream(1, reader, file.length());
			int num = st.executeUpdate();
			while (num>0) {
				System.out.println("插入成功！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("实例化txt文件出错");
			e.printStackTrace();
		} finally{
			JDBCUtil.release(con, st, rs);
			try {
				if (reader!=null) {
					reader.close();
				}
			} catch (IOException e) {
				System.out.println("txtReader关闭失败");
				e.printStackTrace();
			}
		}
	}
	

	/**
	 * 从数据库中读取clob
	 */
	public void read(){
		try {
			con= JDBCUtil.getConnection();
			st = con.prepareStatement("select * from lobtable where id = ?");
			st.setString(1, "1");
			rs=st.executeQuery();
			if (rs.next()) {
				/** 第一种方法时直接把文本读出来
				 * String content = rs.getString("clob"); 
				 * System.out.println(content);
				 */
				reader = rs.getCharacterStream("clob");
				char[] cbuffer = new char[1024];
				int len=0;
				String fwPath=dbDemo.class.getClassLoader().getResource("").getPath();
				FileWriter fw = new FileWriter(fwPath+"clobdataOut.txt");    //在WEB-INF/classes/clobdataOut.txt创建文本
				if ((len = reader.read(cbuffer)) > 0) {
						fw.write(cbuffer, 0, len);
				}
				fw.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JDBCUtil.release(con, st, rs);
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 将blob写入数据库
	 */
	public void writeByte(){
		try {
			//获取链接
			con = JDBCUtil.getConnection();
			String sqlString = "insert into lobtable(id,resum,clob) values('2',?,null)";
			st = con.prepareStatement(sqlString);
			//这种方式获取的路径，其中的空格会被使用“%20”代替
			String txtPath = dbDemo.class.getClassLoader().getResource("xz.jpg").getPath();
			txtPath = txtPath.replaceAll("%20", " ");
			System.out.println(txtPath);
			File file = new File(txtPath);
			InputStream fis = new FileInputStream(txtPath);
			st.setBinaryStream(1, fis, file.length());
			int num = st.executeUpdate();
			if (num>0) {
				System.out.println("插入成功！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("实例化txt文件出错");
			e.printStackTrace();
		} finally{
			JDBCUtil.release(con, st, rs);
			try {
				if (reader!=null) {
					reader.close();					
				}
			} catch (IOException e) {
				System.out.println("txtReader关闭失败");
				e.printStackTrace();
			}
		}
	}
	

	/**
	 * 读取blob
	 */
	public void readByte(){
		try {
			con= JDBCUtil.getConnection();
			st = con.prepareStatement("select * from lobtable where id = ?");
			st.setString(1, "2");
			rs=st.executeQuery();
			if (rs.next()) {
				InputStream is = rs.getBinaryStream("resum");
				byte[] bbuffer = new byte[1024];
				int len=0;
				String fwPath=dbDemo.class.getClassLoader().getResource("").getPath();
				System.out.println(fwPath+"out.jpg");
				FileOutputStream fos = new FileOutputStream(fwPath+"out.jpg");    //在WEB-INF/classes/clobdataOut.txt创建文本
				while ((len = is.read(bbuffer)) > 0) {
					fos.write(bbuffer, 0, len);
				}
				fos.flush();
				is.close();
				fos.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JDBCUtil.release(con, st, rs);
			try {
				if (reader!=null) {
					reader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		dbDemo db = new dbDemo();
		db.readByte();
	}
}
