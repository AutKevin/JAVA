import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 题目：对10个数进行排序
 */
public class Arithmetic_TenNumSort {
	public static void main(String[] args) {
		int[] arr = new int[10000];
		Random r = new Random();
		//初始化10个数的值
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(10*arr.length) + 1; //得到10个100以内的整数
		}
		//计算时间用
		long start,end;
		//调用数组方法
		start = System.currentTimeMillis();
		sortNum(arr);
		end = System.currentTimeMillis();
		System.out.println("用时"+(end-start));
		//冒泡
		start = System.currentTimeMillis();
		sortBuble(arr);
		end = System.currentTimeMillis();
		System.out.println("用时"+(end-start));
	}
	//调用Arrays方法
	public static void sortNum(int[] arr) {
		Arrays.sort(arr);    //调用数组的排序方法
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println("");
	}
	//冒泡
	public static void sortBuble(int[] arr) {
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i]>arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println("");
	}
	
}
