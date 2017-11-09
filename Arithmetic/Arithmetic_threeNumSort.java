public class Arithmetic_threeNumSort{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
		System.out.println("请输入三个数");
		int i = scanner.nextInt();
		int j = scanner.nextInt();
		int k = scanner.nextInt();
		int temp = 0;
		if (i>j) {   //如果第一个比第二个大,则互换位置
			temp = i;
			i=j;
			j=temp;
		}
		if (i>k) {  //如果第一个比第三个大,则互换位置
			temp=i;
			i=k;
			k=temp;
		}
		if (j>k) {  //如果第二个比第三个大,则互换位置
			temp=j;
			j=k;
			k=temp;
		}
		System.out.println("从小到大排序:"+i+","+j+","+k);
    }
}