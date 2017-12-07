package com.demo.impl;

import java.util.ArrayList;

import sun.awt.geom.AreaOp.AddOp;

import com.demo.inf.Company;

/**
 * 树枝节点类 
 */
public class ConcreteCompany implements Company{
	//构件容器
	private ArrayList<Company> companyList = new ArrayList<Company>();
	
	private String name;
	private String sex;
	private String position;
	private int salary;
	
	public ConcreteCompany(String name,String sex, String position, int salary) {
		this.name = name;
		this.sex = sex;
		this.position = position;
		this.salary = salary;
	}
	
	//添加构件
	public void add(Company company){
		this.companyList.add(company);
	}
	
	//删除构件
	public void remove(Company company){
		this.companyList.remove(company);
	}
	
	public ArrayList<Company> getChild(){
		return this.companyList;
	}
	
	//获取子构件
	@Override
	public String getInfo() {
		String info = "";
		info = "名称:"+this.name;
		info+="\t性别"+this.sex;
		info+="\t职位"+this.position;
		info+="\t薪水"+this.salary;
		return info;
	}

}
