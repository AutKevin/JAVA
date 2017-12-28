public class Arithmetic_MonkeyDevidePeach {
	// 题目：海滩上有一堆桃子，五只猴子来分。第一只猴子把这堆桃子凭据分为五份，
	// 多了一个，这只猴子把多的一个扔入海中，拿走了一份。第二只猴子把剩下的桃子又平均分成五份，
	// 又多了一个，它同样把多的一个扔入海中，拿走了一份，第三、第四、第五只猴子都是这样做的，
	// 问海滩上原来最少有多少个桃子？
	public static void main(String[] args) {
		int sum_peach = 1;    //桃子的量
		while (true) {
			int monkey = 0;    //猴子的索引
			int temp_peach = sum_peach;    //将桃子的数量赋给临时变量
			
			for (monkey = 0; monkey < 5; monkey++) {   //遍历猴子
				if ((temp_peach - 1) % 5 == 0)    //判断没分前的量是否是5*n+1
					temp_peach = (temp_peach - 1) / 5 * 4;   //是的话扔掉一个,再分成五份,取其中四份
				else    //如果没分前的量不是5*n+1
					break;    //则跳出循环
			}

			if (monkey == 5)    //当monkey的下标等于5时,此时满足五次均分
				break;
			sum_peach++;    //桃子总量加一
		}
		System.out.println("桃子总数为:"+sum_peach);
		
		
		//桃子开始总量,不能输入大于3121的数字
		//System.out.println(s(0));
	}

	static int s(int sum_peach) {     //桃子总量
		int result_peach = sum_peach;    //记录桃子总量
		for (int monkey = 0; monkey < 5; monkey++) {   // 五个猴子
			if (sum_peach % 5 != 1)   //如果桃子总数不是5n+1时
				return s(result_peach + 1);   //桃子总数加一,尝试下一个桃子量是否满足
			sum_peach = (sum_peach - 1) / 5 * 4;   //当满足5n+1时,循环下一个猴子继续此任务.当最后一个猴子执行完此条件时
		}
		return result_peach;
	}
}
