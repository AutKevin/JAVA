package com.autumn;

import java.util.Arrays;

/**
  * 常用排序方法
  * @ClassName: SortExercise
  * @Description: TODO
 */
public class SortExercise {

	public static void main(String[] args) throws InterruptedException {
		int[] arr = new int[] { 5, 3, 7, 13, 52, 127, 69, 4 };
		/*插入类*/
		simpleInsertSort(arr);  //简单插入排序
		shellSort(arr);    //希尔排序
		
		/*选择类*/
		simpleSelect(arr);  //简单选择排序
		heapSort(arr);  //堆排序
		
		/*交换类*/
		bubbleSort(arr);  //冒泡排序
		quickSort(arr,0,arr.length-1);  //快速排序
		
		/*归并排序*/
        int[] result = mergeSort(arr, 0, arr.length - 1);  //归并排序会产生新的变量,必须用返回值
		System.out.println(Arrays.toString(result));
		
		/*基数排序*/
		radixSort(arr,3);
		
		System.out.println(Arrays.toString(arr));	
	}
	
	/**
	 * 插入类 - 直接插入排序
	 * 稳定排序 时间:O(n^2) 空间:O(1)
	 * @param arr 待排序数组
	 */
	public static void simpleInsertSort(int[] arr){
		if (arr == null || arr.length == 0) {  //不用排序的情况
			return ;
		}
		
		for (int i = 1; i < arr.length; i++) {  //遍历待插入的元素
			int temp = arr[i];  //待插入元素存入temp
			int index = i; //待插入位置下标
			for (int j = i-1; j >= 0; j--) {  //找到元素插入的位置,j代表已排序部分的序列下标
				if (arr[j]>temp) {  //当待插入序列大于已排序元素时
					arr[j+1] = arr[j];  //已排序元素右移一位
					index = j;  //新的待插入下标替换为后移的这个元素位置
				}else {  //加上else这条效率会高很多
					break;  //不做无用功
				}
			}
			arr[index] = temp;
		}
	}
	
    /**
     * 插入类 - 希尔排序
     * 不稳定排序 时间:O(n^1.3 ~ n^2) 空间:O(1)
     * @param arr 待排序数组
     */
	public static void shellSort(int[] arr){
		int len = arr.length;
		//进行分组,最开始的增量gap为数组长度的一半
		for (int gap = len/2; gap >0; gap/=2) {
			//对各个分组进行插入排序
			for (int i = gap; i < len; i++) {  //i为每组第二个元素开始,例如len=8,gap=2时,i为2,3,4,5,6,7.这些下标会和自己所属组的前部分进行插入排序
				//将arr[i]插入到所在分组的正确位置上
				insert_group(arr, gap, i);
			}
		}
	}
	
	/**
	 * 希尔排序组内插入排序 - 待插入排序和前面部分(同组)的进行比较插入
	 * @param arr 待排序数组
	 * @param gap 间隔
	 * @param i 待插入下标
	 */
	private static void insert_group(int[] arr,int gap,int i){
		int inserted = arr[i]; //取出待插入数据元素
		int index = i; //待插入下标 
		int j;
		for (j = i-gap; j>=0 && inserted < arr[j]; j-=gap) {  //循环内只有一个if可以直接卸载for的判断条件里
			arr[j+gap] = arr[j];  //把前一个后移一位
			index = j;  //空出来的下标为待插入位置
		}
		arr[index] = inserted;    
	}
	
	/**
	 * 选择类 - 简单选择排序
	 * 不稳定排序 时间:O(n^2) 空间:O(1)
	 * @param arr 待排序数组
	 */
	public static void simpleSelect(int[] arr){
		try {
			for (int i = 0; i < arr.length-1; i++) {
				int minIndex = i;
				for (int j = i+1; j < arr.length; j++) {
					if (arr[j]<arr[minIndex]) {
						minIndex = j;
					}
				}
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		} catch (Exception e) {
		}
	}
	
    /**
     * 选择类 - 堆排序
     * 不稳定排序 时间:O(nlog2n) 空间:O(1)
     * @param array 待排序数组
     */
	public static void heapSort(int[] arr){
		/*从右到左从下至上每个子树逐步建立最大堆*/
		for (int i = arr.length/2-1; i >= 0; i--) {   //从最后一个非叶子结点(array.length/2 - 1)遍历到根结点
			ajustHeap(arr,i,arr.length); //调整堆,i决定调整的哪个子树
		}
		/*建立最大堆结束,下面开始排序逻辑*/
		//把大顶堆的根元素，放到数组的最后；换句话说，就是每一次的堆调整之后，都会有一个元素到达自己的最终位置
		for (int i = arr.length-1; i >0 ; i--) {  //这里是遍历堆的长度
			swap(arr, 0, i);  //将已排序好的最大堆第一位和最后一位交换位置
			//再重建最大堆
			ajustHeap(arr, 0, i);  //这里其实只要排序第一个元素到指定位置,又会自动把最大值放在堆顶
		}
	}
	
	/**
	 * 建立最大堆
	 * @param arr 待排序数组
	 * @param rootIndex 起始结点
	 * @param len 堆的长度
	 */
	public static void ajustHeap(int[] arr,int rootIndex,int len){
		//2*rootIndex+1为rootIndex的左子树(因为i是从0开始的),2*k+1为k的左子树
		for (int i = 2*rootIndex+1; i < len; i=2*i+1) {  //遍历树的左节点,root根结点->左子节点->左子结点
			
			if (i+1<len && arr[i+1] > arr[i]) {  //如果有右子树,并且右子树大于左子树
				i++;  //让i先指向子节点中最大的节点,同时这一步决定了下一个遍历的是左子树还是右子树
			}
			
			if (arr[rootIndex]<arr[i]) {  //如果根结点小于子结点(左/右子结点)，则进行值的交换
				swap(arr,rootIndex,i);  //根结点和子结点交换
				rootIndex = i;  //根结点更新
			}else{  //此节点大于左右子树,不用交换,直接终止循环
				break;
			}
		}
	}
	
	public static void swap(int[] arr,int a,int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	/**
	  * 交换排序 - 冒泡排序
      * 稳定排序 时间:O(n^2) 空间:O(1)
	  */
	public static void bubbleSort(int[] arr){
		for (int i = 0; i < arr.length-1; i++) {  //遍历循环的圈数(每一次都会有一个最大值放冒泡到后面)
			for (int j = 0; j < arr.length-1-i; j++) {  //这里遍历的范围为length-1-i,预留一位用于+1和后一位比较,每次都会有最大值到末位
				if (arr[j]>arr[j+1]) {
					swap(arr, j, j+1);
				}
			}
		}
	}
	
	/**
	 * 交换排序 - 快速排序
	 * 不稳定排序 时间:O(nlog2n~n^2) 空间:O(log2n)
	 * @param arr 数组
	 * @param low 最低位
	 * @param high 最高位
	 */
	public static void quickSort(int[] arr,int low,int heigh){
		if (low>=heigh) {
			return;
		}
		int index = getIndex(arr, low, heigh);
		quickSort(arr, low, index-1);
		quickSort(arr, index+1, heigh);
	}
	
	//交换排序-获取基数下标
	public static int getIndex(int[] arr,int low,int heigh){
		int basic = arr[low];  //以首位为基准
		while (low < heigh) {
			while (low<heigh && arr[heigh] > basic) {  //如果高位大于基准值,高位下标-1,直到找到heigh位小于基准值的下标
				heigh--;
			}
			arr[low] = arr[heigh];  //把高位赋给地位(第一次会把基准位0覆盖掉)
			
			while (low<heigh && arr[low] < basic) {  //如果地位小于基准值,自减1,直到找到low位小于基准值的下标
				low++;
			}
			arr[heigh] = arr[low];
		}
		arr[low] = basic;
		return low;
	}
	
	/**
	 * 归并排序
	 * 稳定排序 时间:O(nlog2n) 空间:O(n)
     * @param arr 数组
     * @param low 最低位
     * @param high 最高位
     * @return 返回新的数组
	 * @return
	 */
	public static int[] mergeSort(int[] arr, int low, int high) {
        if (low == high)  //出口
            return new int[] { arr[low] };
         
        int mid = low + (high - low) / 2;
        int[] leftArr = mergeSort(arr, low, mid);    //递归左有序数组,返回的数组时排序好的
        int[] rightArr = mergeSort(arr, mid + 1, high);    //递归右有序数组,返回的数组时排序好的
        int[] newNum = new int[leftArr.length + rightArr.length];    //新有序数组
         
        int m = 0, l = 0, r = 0;    //m是新数组目前下标,l是左数组下标,r是右数组下标
        /**
         * 将左右有序数组按大小赋值到新数组中,直到其中一个数组结束(此时另一个数组剩下的部分一定比已排序数组最后一个大)
         */
        while (l < leftArr.length && r < rightArr.length) {  
            newNum[m++] = leftArr[l] < rightArr[r] ? leftArr[l++] : rightArr[r++];  //比较两个数组中哪个值小并赋给新数组
        }
        
        //只需要把另一个数组剩下的部分直接赋给新数组即可,下面这两个while只会执行一个
        while (l < leftArr.length)
            newNum[m++] = leftArr[l++];
        while (r < rightArr.length)
            newNum[m++] = rightArr[r++];
        return newNum;
    }
	
	/**
	 * 基数排序
	 * @param arr 待排序数组
	 * @param d 表示最大的数有多少位
	 */
	public static void radixSort(int[] arr, int d)
	{
		int k = 0;
		int n = 1;
		int m = 1; //控制键值排序依据在哪一位
		int[][] temp = new int[10][arr.length];  //数组的第一维表示可能的余数0-9
		int[] order = new int[10];  //数组orderp[i]用来表示该位是i的数的个数
		while (m <= d) {
			for (int i = 0; i < arr.length; i++) {
				int lsd = ((arr[i] / n) % 10);
				temp[lsd][order[lsd]] = arr[i];
				order[lsd]++;
			}
			for (int i = 0; i < 10; i++) {
				if (order[i] != 0)
					for (int j = 0; j < order[i]; j++) {
						arr[k] = temp[i][j];
						k++;
					}
				order[i] = 0;
			}
			n *= 10;
			k = 0;
			m++;
		}
	}
}
