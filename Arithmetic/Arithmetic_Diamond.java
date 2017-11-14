public class Arithmetic_Diamond {
	/*
	 * 题目：打印出如下图案（菱形）
	 */
	public static void main(String[] args) {
		System.out.println("三角形打印方法");
		printTriangle();
		System.out.println("菱形打印方法");
		printDiamond();
	}
	//三角形
	public static void printTriangle() {
		// 前半部分(四行)
		for (int i = 1; i <= 4; i++) {    //四行,第1,2,3,4行
			for (int j = 1; j <= 2 * i - 1; j++) {    //每行的列数和行索引关系为num=2*i-1
				System.out.print("*");
			}
			System.out.println();
		}
		// 后半部分(三行)
		for (int i = 3; i >= 1; i--) {   //三行,第5,6,7行,因为567和321一样,所以我们在把321行倒过来打印
			for (int j = 1; j <= 2 * i - 1; j++) {     //行列关系还是2*i-1
				System.out.print("*");
			}
			System.out.println();
		}
	}
	//菱形
	public static void printDiamond() {
		//打印菱形上半部分(四行)
		for (int i = 1; i <= 4; i++) {    //1,2,3,4行
			//打印空格数,空格规律为3,2,1,0.即4-i
			for (int j = 1; j <= 4-i; j++) {
				System.out.print(" ");
			}
			//每行的星数,1,3,5,7,和行数关系为2*i-1
			for (int j = 1; j <= 2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		//打印菱形下半部分(三行)
		for (int i = 3; i >= 1; i--) {   //567行,但与321一样,所以把123行倒过来打印即可
			for (int j = 1; j <= 4-i; j++) {   //空格数仍然是4-i
				System.out.print(" ");
			}
			for (int j = 1; j <= 2*i-1; j++) {  //打印星
				System.out.print("*");
			}
			System.out.println();
		}
	}
}