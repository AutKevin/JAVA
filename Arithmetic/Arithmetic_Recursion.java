public class Arithmetic_Recursion {
	/*
	 * 题目：利用递归方法求5!。 
	 */
	public static void main(String[] args) {
		int recFive = getRecursion(5);
		System.out.println(recFive);
	}
	//第i项的值
	public static int getRecursion(int i){
		if (i==1) {
			return 1;
		}
		return getRecursion(i-1)*i;
	}
}