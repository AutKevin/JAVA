import java.util.Scanner;

public class Arithmetic_strLen {
	//题目：写一个函数，求一个字符串的长度，在main函数中输入字符串，并输出其长度。
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String content = scanner.nextLine();
		System.out.println(getLen(content));
	}
	
	/**
	 * 获取字符串长度
	 * @param str  字符串
	 * @return  长度
	 */
	public static int getLen(String str){
		return str.length();
	}
}
