public class Arithmetic_Age {
	/*
	 * 题目：有5个人坐在一起，问第五个人多少岁？他说比第4个人大2岁。
	 * 问第4个人岁数，他说比第3个人大2岁。
	 * 问第三个人，又说比第2人大两岁。
	 * 问第2个人，说比第一个人大两岁。
	 * 最后问第一个人，他说是10岁。请问第五个人多大？
	 */
	public static void main(String[] args) {
		System.out.println("第五个人的年龄为:"+getAge(5));
	}
	
	/**
	 * 根据第几个人返回年龄
	 * @param i  第i个人
	 * @return 年龄
	 */
	public static int getAge(int i){
		if (i==1) {
			return 10;
		}else {
			return getAge(i-1)+2;
		}
	}
}