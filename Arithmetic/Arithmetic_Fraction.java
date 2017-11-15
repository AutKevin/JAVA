public class Arithmetic_Fraction {
	/*
	 * 题目：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。 
	 */
	public static void main(String[] args) {
		double sum = 0;
		for (int i = 1; i < 21; i++) {
			double num = getFractionFenshu(i);   //第i项分数
			sum+=num;
		}
		System.out.println(sum);
	}
	//获取分子
	public static double getFractionFenzi(double i){
		if (i==1) {
			return 2;
		}else if (i==2){
			return 3;
		}else {
			return getFractionFenzi(i-1)+getFractionFenzi(i-2);
		}
	}
	//获取分母
	public static double getFractionFenmu(double i){
		if (i==1) {
			return 1;
		}else if (i==2){
			return 2;
		}else {
			return getFractionFenmu(i-1)+getFractionFenmu(i-2);
		}
	}
	//获取分数
	public static double getFractionFenshu(double i){
		return getFractionFenzi(i)/getFractionFenmu(i);
	}
}