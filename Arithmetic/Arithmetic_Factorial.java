public class Arithmetic_Factorial {
	/*
	 * 题目：求1+2!+3!+...+20!的和
	 */
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 20; i++) {
			System.out.println("第"+i+"项阶乘值为："+getFactorial(i));
			sum+=getFactorial(i);
		}
		System.out.println("1+2!+3!+...+20!的和为："+sum);
		getFactorial20();
	}

	//第i项的阶乘值f(n)=f(n-1)*n
	public static int getFactorial(int i){
		if (i==1) {   //第一项为1
			return 1;
		}
		return getFactorial(i-1)*i; //阶乘值=上一个阶乘值*第n项
	}
	//第二种方法,通过循环计算出每一个阶乘项的值
	public static int getFactorial20(){
		int sum = 0;
		int fac = 1;
		for (int i = 1; i <= 20; i++) {    //总共20项
			fac*=i;    //没一项的值
			System.out.println("@方案two"+i+"项阶乘值为："+fac);
			sum+=fac;
		}
		System.out.println("@方案two1+2!+3!+...+20!的和为："+sum);
		return sum;
	}
}
