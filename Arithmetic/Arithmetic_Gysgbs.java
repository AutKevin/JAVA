public class Arithmetic_Gysgbs{
    //题目：输入两个正整数m和n，求其最大公约数和最小公倍数。
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        int m = in.nextInt();
        System.out.println("请输入第二个数字：");
        int n = in.nextInt();
        System.out.println("最大公约数:"+getMaxMult(m,n));
        System.out.println("--------------------------");
        System.out.println("最小公倍数:"+gbs(m,n));
	}
	//求两个数的最大公约数
	public static int getMaxMult(int m,int n) {
		if (n == 0) {
			return m;
		} else {
			System.out.println("m值为"+m+"，n值为"+n);
			return getMaxMult(n, m % n);   //辗转相除法
		}
        }
	//求两个数的最小公倍数
	public static int gbs(int m,int n) {
		int gys = getMaxMult(m,n);
		return m*n/gys;    //两数相乘除以最大公约数就是最小公倍数
        }
}