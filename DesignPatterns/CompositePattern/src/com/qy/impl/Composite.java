package com.qy.impl;

import java.util.ArrayList;
import com.qy.inf.Component;

/**
 * 树枝构件 
 */
public class Composite implements Component {
	//构建容器
	private ArrayList<Component> componentList = new ArrayList<Component>();
	//添加构件
	public void add(Component component){
		this.componentList.add(component);
	}
	//删除构件
	public void remove(Component component){
		this.componentList.remove(component);
	}
	//获取子构件
	public ArrayList<Component> getChild(){
		return this.componentList;
	}
	
	@Override
	public void operation() {
		//省略业务逻辑代码
		System.out.println(this.toString()+"树枝构建业务");
	}
}
