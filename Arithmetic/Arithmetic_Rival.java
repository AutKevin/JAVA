public class Arithmetic_Rival {
	/*
	 * 题目：两个乒乓球队进行比赛，各出三人。甲队为a,b,c三人，乙队为x,y,z三人。已抽签决定比赛名单。有人向队员打听比赛的名
	 * 单。a说他不和x比，c说他不和x,z比，请编程序找出三队赛手的名单。
	 */
	public static void main(String[] args) {
		for (int a = 'x'; a <= 'z'; a++) { // 变量a代表a的对手
			if (a != 'x') { // a不和x比
				for (int b = 'x'; b <= 'z'; b++) { // b的对手
					for (int c = 'x'; c <= 'z'; c++) { // c的对手
						if (c != 'x' && c != 'z') {  //c不和x和z比
							// 隐藏条件,abc三位选手的对手不可能相同
							if (a != c && b != c && a != b) { 
								System.out.print("a对手为" + (char) a + ",b对手为"	+ (char) b + ",c对手为" + (char) c);
							}
						}
					}
				}
			}
		}
	}
}