import java.util.Scanner;

public class Arithmetic_JudNumber {
	/*
	 * 题目：给一个不多于5位的正整数，要求：一、求它是几位数，二、逆序打印出各位数字。
	 */
	public static void main(String[] args) {
		//getNum();
		getNum2();
	}
	//方法一
	public static void getNum(){
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int count = 0;  //记录位数
		int weishu = 0;  //得到的每一位
		int nixu = 0;  //逆序数字
		if(num<0||num>99999){
			System.out.println("数值不符合要求");
			System.exit(0);
		}
		do {
			//这样倒叙太麻烦,采用第二种方式把int转为string,再由string转为char[],再由char[]变为string
			nixu = nixu*10;   //逆序数要*10来放下一位
			weishu = num % 10; //在num去掉末位数之前得到末位数
			nixu+=weishu;   //然后末位数加到逆序数上面
			
			num = num/10;
			count++;
			if (num==0) {
				break;
			}
		} while (true);
		System.out.println("一共有:"+count+"位,逆序为:"+nixu);		
	}
	//方法二
	public static void getNum2(){
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		if (num<0||num>99999) {
			System.out.println("数值不符合要求");
			System.exit(0);
		}
		if(num >=0 && num <=9) {
		    System.out.println( num + "是一位数");
		    System.out.println("按逆序输出是" + '\n' + num);
		   } else if(num >= 10 && num <= 99) {
		    System.out.println(num + "是二位数");
		    System.out.println("按逆序输出是"+revert(num));
		   } else if(num >= 100 && num <= 999) {
		    System.out.println(num + "是三位数");
		    System.out.println("按逆序输出是"+revert(num));
		   } else if(num >= 1000 && num <= 9999) {
		    System.out.println(num + "是四位数");
		    System.out.println("按逆序输出是"+revert(num));
		   } else if(num >= 10000 && num <= 99999) {
		    System.out.println(num + "是五位数");
		    System.out.println("按逆序输出是"+revert(num));
		   }
	}
	//倒序输出
	public static String revert(int num){
		StringBuilder stringBuilder = new StringBuilder();
		String result = Integer.toString(num);
		char[] arr = result.toCharArray();
		for (int i = arr.length-1; i >=0 ; i--) {
			stringBuilder.append(arr[i]);
		}
		return stringBuilder.toString();
	}
}