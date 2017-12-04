import java.util.Random;


public class Arithmetic_InvertArr {
	//题目：将一个数组逆序输出。
	public static void main(String[] args) {
		
		int[] arr = new int[8];
		Random random = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(100);
			System.out.print(arr[i]+"\t");
		}
		System.out.println("\r\n倒序:");
		for (int i = arr.length-1; i >=0 ; i--) {
			System.out.print(arr[i]+"\t");
		}
	}

}
