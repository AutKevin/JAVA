package com.qy.zip;
public class Arithmetic_ball{
    //题目：一球从100米高度自由落下，每次落地后反跳回原高度的一半；
    //再落下，求它在   第10次落地时，共经过多少米？第10次反弹多高？   
    public static void main(String[] args){
        double height = 100.0;
        double sum = 0;
        for (int i = 1; i < 20; i++) {
			sum+=height;    //落地时经过的高度
			height*=0.5;    //弹起的高度
			System.out.println("第"+(i)+"次落地时,经过的高度为"+sum);
			System.out.println("第"+(i)+"次落地是弹起高度:"+height+"米");
	}
    }
}