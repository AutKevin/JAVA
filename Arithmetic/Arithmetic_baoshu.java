import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sun.org.apache.bcel.internal.generic.RETURN;


public class Arithmetic_baoshu {
	//题目：有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问最后留下的是原来第几号的那位。
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int len = scanner.nextInt();
		boolean[] arr = new boolean[len];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = true;  //初始化全部在圈内
		}
		int index = 0;    //下标
		int countNum = 0;    //计数
		int leftCount = len;
		do {
			if (arr[index]) {    //是圈内的人时
				countNum++;   //报数
				if (countNum==3) {   //当这个人报数为三时
					arr[index] = false;    //这个人出圈
					leftCount--;    //剩余人数减一
					countNum = 0; //报数重置为0
				}
			}
			//数组下标和在不在圈内无关
			index++;   //下一个人的下标
			if (index==len) {   //当下标等于长度时
				index = 0;   //下标重置为零
			}
		} while (leftCount>1);
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]) {
				System.out.println("最后剩的人下标为"+i);
			}
		}
	}
}
