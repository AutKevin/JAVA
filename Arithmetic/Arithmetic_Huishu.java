import java.util.Scanner;

public class Arithmetic_Huishu {
	/*
	 * 题目：一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同。
	 */
	public static void main(String[] args) {
		int num = 0;
		Scanner scanner = new Scanner(System.in);
		num = scanner.nextInt();
		String numString = Integer.toString(num);
		char[] numArr = numString.toCharArray();
		int endIndex = numArr.length-1;
		boolean flag = true; //
		for (int i = 0; i <= endIndex; i++) {
			if (i==endIndex||i>endIndex) {
				break;
			}
			if(numArr[i]!=numArr[endIndex]){
				flag = false;
				break;
			}
			endIndex-=1;
		}
		if (flag) {
			System.out.println("是回数");
		}else {
			System.out.println("不是回数");
		}
	}
}