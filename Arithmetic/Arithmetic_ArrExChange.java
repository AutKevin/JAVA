import java.util.Random;


public class Arithmetic_ArrExChange {
	//题目：输入数组，最大的与第一个元素交换，最小的与最后一个元素交换，输出数组。
	public static void main(String[] args) {
		Random random = new Random();
		int len = random.nextInt(5)+5;    //数长度为5到10
		int[] arr = new int[len];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(100);
		}
		System.out.println("原数组:");
		printArr(arr);
		int maxIndex = 0;    //默认第一项为最大值
		int minIndex = 0;    //默认最小值为第一项
		for (int i = 0; i < arr.length; i++) {    //遍历每一项
			if (arr[i]>arr[maxIndex]) {     //判断每一项是否比最大值大
				maxIndex = i;     //如果是,则记录该最大值index
			}
			if (arr[i]<arr[minIndex]) {
				minIndex = i;
			}
		}
		//交换最大值和第一项
		int temp = arr[0];
		arr[0] = arr[maxIndex];
		arr[maxIndex] = temp;
		//最小值和最后一项交换
		temp = arr[arr.length-1];
		arr[arr.length-1] = arr[minIndex];
		arr[minIndex] = temp;
		System.out.println("交换后数组:");
		printArr(arr);
		System.out.println("最大值index"+maxIndex);
		System.out.println("最小值index"+minIndex);
		
	}
	//打印数组
	public static void printArr(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println("");
	}
}
