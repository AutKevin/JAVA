public class Arithmetic_Monkey{
    /*题目：猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个 第二天早上又将剩下的桃子吃掉一半，
	又多吃了一个。以后每天早上都吃了前一天剩下的一半零一个。到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。*/  
    public static void main(String[] args){
    	/*int left = 1;   //每天早上剩下的桃子数量
    	for (int i = 10; i >0; i--) {
			System.out.println("第"+i+"天,"+"早上还剩"+left+"个");
			left=(left+1)*2;
		}*/
    	for (int i =1; i < 11; i++) {
			System.out.println("第"+i+"天,"+"还剩"+total(i));
		}
    }
    //每天早上的桃子数
    public static int total(int day){
    	if (day==10) {
			return 1;    //第十天还剩一个
		}else {
			return (total(day+1)+1)*2;   //每天早上的剩余数都是下一天早上的+1乘以2
		}
    }
}