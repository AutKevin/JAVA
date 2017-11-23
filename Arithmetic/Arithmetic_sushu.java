/**
 * 题目：求100之内的素数  
 */
public class Arithmetic_sushu {
	public static void main(String[] args) {
		int sum;
		for (sum = 2; sum <= 100; sum++) {
			//zhishu(sum);
			if (isZhiShu(sum)) {
				System.out.println(sum);
			}
		}
	}
	public static void zhishu(int sum) {
		int i;
		for (i = 2; i <= Math.sqrt(sum); i++) {
			if (sum % i == 0)
				break;
		}
		if (i > Math.sqrt(sum))
			System.out.println(sum + "是素数");
	}
	
	public static boolean isZhiShu(int num){
       if(num==2){
           return true;
       }
       
       if(num<2||num%2==0){    //2是最小的整数,所以小于2和能被2整除的都不是质数
           return false;
       }
       
       for(int i =3;i<Math.sqrt(num);i=i+2){    //从三开始一直到num的开根的所有奇数(偶数一定不是质数,所以全部取奇数.开根是因为一个数的)
           if(num%i==0){
               return false;
           }
       }
       return true;
   }
}
