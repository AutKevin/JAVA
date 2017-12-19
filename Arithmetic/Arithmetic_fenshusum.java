import java.util.Scanner;

public class Arithmetic_fenshusum {
	//题目：编写一个函数，输入n为偶数时，调用函数求1/2+1/4+...+1/n,当输入n为奇数时，调用函数1/1+1/3+...+1/n
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		double sum = 0;
		if (num%2!=0) {
			for (int i = 1; i <= num; i=i+2) {
				sum += 1.0/i;
				System.out.print(1+"/"+i+"\t");
				System.out.print(1.0/i+"\t");
				System.out.println("");
			}
		}else {
			for (int i = 2; i <= num; i=i+2) {
				sum += 1.0/i;
				System.out.print(1+"/"+i+"\t");
				System.out.print(1.0/i+"\t");
				System.out.println("");
			}
		}
		System.out.println(sum);
	}
}
