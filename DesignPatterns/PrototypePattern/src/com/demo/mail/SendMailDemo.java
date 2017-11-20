package com.demo.mail;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * 调用
 */
public class SendMailDemo {
	Map students = new LinkedHashMap();
	public static void main(String[] args) {
		//创建一个原型mail
		Mail mail = new Mail("邮件标题", "邮件内容");
		mail.setTail("2017-11-20");
		SendMailDemo sendMailDemo = new SendMailDemo();
		//获取所有学生
		Map students=sendMailDemo.getStudent();
		for (Object name : students.keySet()) {
			//克隆邮件
			Mail cloneMail = mail.clone();
			cloneMail.setAppellation(name.toString());
			cloneMail.setReceiver(students.get(name).toString());
			sendMailDemo.sendMail(cloneMail);
		}
		
	}
	public Map getStudent(){
		students.put("studentone", "1@foxmail.com");
		students.put("studenttwo", "2@foxmail.com");
		students.put("studentthree", "3@foxmail.com");
		students.put("studentfour", "4@foxmail.com");
		students.put("studentfive", "5@foxmail.com");
		students.put("studentsix", "6@foxmail.com");
		students.put("studentseven", "7@foxmail.com");
		return students;
	}
	public void sendMail(Mail mail){
		System.out.println("标题:"+mail.getSubject()+"\t收件人邮箱:"+mail.getReceiver()+"\t正文:"+mail.getAppellation()+mail.getContxt()+"\t...已发送");
	}
}
