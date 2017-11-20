package com.demo.mail;

/**
 * 实现clone接口,实现了clone方法,是实现克隆的关键
 */
public class Mail implements Cloneable {
	//收件人
	private String receiver;
	//邮件标题
	private String subject;
	//称谓
	private String appellation;
	//邮件内容
	private String contxt;
	//尾部
	private String tail;
	//构造函数
	public Mail(String subject,String contxt) {
		this.subject = subject;
		this.contxt = contxt;
	}
	//克隆方法
	public Mail clone() {
		Mail mail = null;
		try {
			mail=(Mail) super.clone();
			System.out.println(super.toString());   //super指的是被调用的那个对象
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return mail;
	}
	/**
	 * @return the receiver
	 */
	public String getReceiver() {
		return receiver;
	}
	/**
	 * @param receiver the receiver to set
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return the appellation
	 */
	public String getAppellation() {
		return appellation;
	}
	/**
	 * @param appellation the appellation to set
	 */
	public void setAppellation(String appellation) {
		this.appellation = appellation;
	}
	/**
	 * @return the contxt
	 */
	public String getContxt() {
		return contxt;
	}
	/**
	 * @param contxt the contxt to set
	 */
	public void setContxt(String contxt) {
		this.contxt = contxt;
	}
	/**
	 * @return the tail
	 */
	public String getTail() {
		return tail;
	}
	/**
	 * @param tail the tail to set
	 */
	public void setTail(String tail) {
		this.tail = tail;
	}
}
