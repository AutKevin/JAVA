import com.sun.org.apache.bcel.internal.generic.RETURN;


public class Arithmetic_yanghui {
	//题目：打印出杨辉三角形（要求打印出10行如下图）
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(getNumByCod(i, j)+"   ");
			}
			System.out.println("");
		}
	}
	
	/**
	 * @param i  第几行
	 * @param j  第几列
	 * @return 返回指定坐标的值
	 */
	public static int getNumByCod(int i,int j){
		if (i==0 || j==0 || i==j) {   //当第一行为1(上边界),第一列全为1(左边界),行等于列也为1(右边界)
			return 1;
		}else {   //其他的为上一行的两列之和
			return getNumByCod(i-1, j-1)+getNumByCod(i-1, j);
		}
	}
}
