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
		String input = "";
		do {
			String day = sc.next();
			input+=day;
			System.out.println("输入:" + input);
			//存储周几的index
			List<Integer> indexList= new ArrayList<Integer>();
			for (int i = 0; i < ls.size(); i++) {
				Pattern p = Pattern.compile("^" + input.toLowerCase());
				Matcher m = p.matcher(ls.get(i).toLowerCase());
				boolean b = m.find(); // 是否找到以输入值开头的
				if (b) {
					indexList.add(i);
				}
			}
			if (indexList.size() > 1) {
				System.out.println("您输入的可能是:");
				for (int i = 0; i < indexList.size(); i++) {
					System.out.println(ls.get(indexList.get(i)));
				}
				System.out.println("请输入下一个字母");
			} else if (indexList.size() == 1) {
				System.out.println("输入的为:" + ls.get(indexList.get(0)));
				input = "";
			} else {
				System.out.println("识别不了您输入的是周几");
				input = "";
			}
		} while (true);
	}
}
