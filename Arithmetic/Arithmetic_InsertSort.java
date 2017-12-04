import java.util.Random;
import java.util.Scanner;

public class Arithmetic_InsertSort {
	//题目：有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中。
	public static void main(String[] args) {
		int[] arr = new int[9];
		//初始化length-1个数
		Random random = new Random();
		for (int i = 0; i < arr.length - 1; i++) {
			int temp = random.nextInt(100);
			arr[i]=temp;
		}
		
		//排序
		sort(arr);
		
		//打印结果
		System.out.println("插入前排序");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println("");
		
		//插入一个数
		Scanner scanner = new Scanner(System.in);
		arr[0] = scanner.nextInt();
		//打印插入后的结果
		sort(arr);
		System.out.println("插入后排序");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println("");
	}
	//排序
	public static void sort(int[] arr){
		//Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i]>arr[j]) {
					int temp  = arr[i];
					arr[i] = arr[j];
					arr[j]= temp; 
				}
			}
		}
	}
}
