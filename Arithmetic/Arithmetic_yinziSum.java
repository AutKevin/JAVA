import java.util.Scanner;

public class Arithmetic_yinziSum{
    //题目：一个数如果恰好等于它的因子之和，这个数就称为 "完数 "。例如6=1＋2＋3.编程   找出1000以内的所有完数。
    	public static void main(String[] args) {
		for(int i=1;i<=1000;i++){
			boolean result=isWanShu(i);
			if(result){
				System.out.println(i);
			}
		}
	}
	
	public static boolean isWanShu(int number) {
		int sum = 0;
		for(int i=1;i<number;i++){
			if(number%i==0){
				sum+=i;
			}
		}
		if(sum==number){
			return true;
		}else{
			return false;
		}
    	}
}