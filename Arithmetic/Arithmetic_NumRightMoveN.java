import java.util.Random;


public class Arithmetic_NumRightMoveN {
	//题目：有n个整数，使其前面各数顺序向后移m个位置，最后m个数变成最前面的m个数
	public static void main(String[] args) {
		Random random = new Random();
		int len = random.nextInt(5)+5;    //数长度为5到10
		int[] arr = new int[len];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(100);
		}
		System.out.println("原数组:");
		printArr(arr);
		int rightMove = random.nextInt(3)+2;
		System.out.println("右移"+rightMove);
		int[] rigthArr= new int[rightMove];    //右侧被移到前面的数组
		for (int i = 0; i < rightMove; i++) {    
			rigthArr[i] = arr[arr.length-rightMove+i];
		}
		printArr(rigthArr);
		for (int i = arr.length-rightMove-1; i >=0 ; i--) {    //数组左半部分向右移
			arr[i+rightMove] = arr[i];
		}
		for (int i = 0; i < rigthArr.length; i++) {    //右半部分移到左边
			arr[i] = rigthArr[i];
		}
		System.out.println("右移"+rightMove+"位后的数组");
		printArr(arr);
	}
	//打印数组
	public static void printArr(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println("");
	}
}
