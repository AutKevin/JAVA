import java.util.*;
import java.io.*;
public class Arithmetic_maddmmaddmmm{
    
	//题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。
	public static void main(String[] args) {
			/*Scanner in = new Scanner(System.in);
        	System.out.println("请输入数值:");
        	int num = in.nextInt();
        	System.out.println("请输入次数:");
        	int count = in.nextInt();
			countNum(num,count);*/
			
			BufferedReader stadin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("请输入数值:");
			String input =stadin.readLine();
			int num = Integer.valueOf(input);
			System.out.println("请输入次数:");
			String countString =stadin.readLine();
			int count = Integer.valueOf(countString);
        	countNum(num,count);
	}
	
	//求总和
	public static void countNum(int num,int count) {
		int i = 0;
		int sum = 0;
		int gewei = num;
		do {
			i++;
			System.out.println("当前值为"+num);
			sum+=num;    //求和
			num=num*10+gewei;   //下一位num的值后面在加一位数字的做法
		} while (i<count);
		System.out.println("总和为:"+sum);
    	}
}