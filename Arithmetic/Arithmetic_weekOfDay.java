import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 题目：请输入星期几的第一个字母来判断一下是星期几，
 * 如果第一个字母一样，则继续   判断第二个字母。  
 */
public class Arithmetic_weekOfDay {
	public static void main(String[] args) {
		//Monday Tuesday Wednesday Thursday Friday Saturday Sunday
		Scanner sc = new Scanner(System.in);
		List<String> ls = new ArrayList<String>();
		ls.add("Monday");
		ls.add("Tuesday");
		ls.add("Wednesday");
		ls.add("Thursday");
		ls.add("Friday");
		ls.add("Saturday");
		ls.add("Sunday");
		do {
			String day = sc.next();
			System.out.println("输入:" + day);
			int index = -1;
			int count = 0;
			for (int i = 0; i < ls.size(); i++) {
				Pattern p = Pattern.compile("^" + day.toLowerCase());
				Matcher m = p.matcher(ls.get(i).toLowerCase());
				boolean b = m.find(); // 是否找到以输入值开头的
				if (b) {
					index = i;
					count++;
				}
			}
			if (count > 1) {
				System.out.println("输入字母不足以判断是周几,请重新输入...");
			} else if (count == 1) {
				System.out.println("输入的为:" + ls.get(index));
			} else {
				System.out.println("识别不了您输入的是周几");
			}
		} while (true);
	}
}
