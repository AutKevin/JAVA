
public class Arithmetic_RightFourAndSeven {
	//题目：取一个整数a从右端开始的4～7位。 
	public static void main(String[] args) {
		int num = 465897;
		String r = Integer.toBinaryString(num);
		System.out.println("整数二进制值:"+r);
		int num4 = num>>4;
		String intr = Integer.toBinaryString(num4);   //二进制下标从零开始,即移除0-3位
		System.out.println("整数左移四位:"+intr);
		//0代表32位个0,
		//~0代表32个1(11111111111111111111111111111111),
		//~0 << 4代表向左移四位,末尾补0(11111111111111111111111111110000),
		//~(~0 << 4)非代表取反(1111)
		int b = ~(~0 << 4);    //0-3位移除后,末尾为4-7,所以要得到末尾四位的数即可
		System.out.println(Integer.toBinaryString(b));
		System.out.println("整数右端的4-7位为:"+Integer.toBinaryString(b&(num>>4)));   
	}

}
