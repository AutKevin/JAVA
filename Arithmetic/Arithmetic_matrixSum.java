import java.util.Random;

/**
 * 题目：求一个3*3矩阵对角线元素之和
 */
public class Arithmetic_matrixSum {
	public static void main(String[] args) {
		int[][] arr = new int[3][3];
		setMatrix(arr);
		printMatrix(arr);
		getMatrixDiagonalSum(arr);
	}
	/**设置随机矩阵*/
	public static void setMatrix(int[][] arr){
		Random random = new Random();
		int num = 0;
		for (int i = 0; i < arr.length; i++) {    //行
			for (int j = 0; j < arr[i].length; j++) {   //列
				num = random.nextInt(100);
				arr[i][j] = num;
			}
		}
	}
	/**打印矩阵*/
	public static void printMatrix(int[][] arr){
		for (int i = 0; i < arr.length; i++) {    //行
			for (int j = 0; j < arr[i].length; j++) {    //列
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println("");
		}
	}
	/**求矩阵对角线和*/
	public static void getMatrixDiagonalSum(int[][] arr){
		int sum = 0;
		if (arr==null||(arr.length!=arr[0].length)) {    //不是正方形矩阵
			System.out.println("该矩阵无对角线,请输入n*n矩阵");
			return;
		}
		System.out.println("求对角线:");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) { 
				if (i==j) {    //当行等于列时
					sum += arr[i][j];
					System.out.print(arr[i][j]+"\t");
				}
			}
		}
		System.out.println("一条对角线和"+sum);
		sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) { 
				if (i+j==arr.length-1) {    //另一条对角线规律
					sum += arr[i][j];
					System.out.print(arr[i][j]+"\t");
				}
			}
		}
		System.out.println("另一条对角线和"+sum);
	}
}
