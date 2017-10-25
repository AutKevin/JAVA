public class Arithmetic_CharCount{
        //题目：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        	System.out.println("请输入字符:");
        	String m = in.nextLine();
        	countNum(m);
	}
	
	public static void countNum(String m) {
		int english = 0;
		int blank = 0;
		int number = 0;
		int other = 0;
		int chinese = 0;
		String Echinese="[\u4e00-\u9fa5]";  //中文范围
		
		char[] charr= m.toCharArray();
		String[] strArr = new String[charr.length];
		for (int i = 0; i < charr.length; i++) {
			strArr[i] = String.valueOf(charr[i]);  //将char数组转换成string数组
			System.out.print("字符: "+m.charAt(i));
			System.out.println(";字对应的值: "+Integer.valueOf(m.charAt(i)));
		}
		
		for (int i = 0; i < strArr.length; i++) {
			if (strArr[i].matches(Echinese)) {
				chinese++;
			}else if (Character.isLetter(strArr[i].charAt(0))) {  //strArr[i].charAt(0)>=65&&strArr[i].charAt(0)<=90||strArr[i].charAt(0)>=97&&strArr[i].charAt(0)<=122
				english++;
			}else if (Character.isDigit(strArr[i].charAt(0))) {   //charr[i]>=48&&charr[i]<=57
				number++;
			}else if (charr[i]==32) {    //Character.isSpaceChar(strArr[i].charAt(0))
				blank++;
			}else {
				other++;
			}
		}
		System.out.println("中文数量:"+chinese);
		System.out.println("英文数量:"+english);
		System.out.println("空格数量:"+blank);
		System.out.println("数字数量:"+number);
		System.out.println("其他字符数量:"+other);
    }	
}