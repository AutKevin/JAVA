package com.qy.AbstractFactoryImpl;

import com.qy.AbstractFactoryI.IBook;

public class Book implements IBook {
	String company = "";
	String bookName = "";
	public Book(String company,String bookName) {
		this.company = company;
		this.bookName = bookName;
	}
	@Override
	public void method1() {
		System.out.print("我们是"+company+"公司,我们发行的书是"+bookName);
		System.out.println("this is book method1 by "+this.getClass().getName());
	}

	@Override
	public void method2() {
		System.out.print("我们是"+company+"公司,我们发行的书是"+bookName);
		System.out.println("this is book method2 by "+this.getClass().getName());
	}

}
