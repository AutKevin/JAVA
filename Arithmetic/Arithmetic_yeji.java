public class Arithmetic_yeji{
    public static void main(String[] args){
        /*题目：企业发放的奖金根据利润提成。利润(I)低于或等于10万元时，奖金可提10%；利润高于10万元，低于20万元时，低于10万
    	元的部分按10%提成，高于10万元的部分，可可提成7.5%；20万到40万之间时，高于20万元的部分，可提成5%；40万到60万之间时高
    	于40万元的部分，可提成3%；60万到100万之间时，高于60万元的部分，可提成1.5%，高于100万元时，超过100万元的部分按1%提成，从
    	键盘输入当月利润I，求应发放奖金总数？*/
    	Scanner scanner = new Scanner(System.in);
    	double jj = 0;
    	System.out.println("请输入利润(万元)");
    	int lirun= scanner.nextInt();
    	if (lirun<=10) {
			jj=lirun*0.1;
		}else if(lirun>10&&lirun<=20) {
			jj=10*0.1+(lirun-10)*0.75;
		}else if (lirun>20&&lirun<=40) {
			jj=10*0.1+10*0.75+(lirun-20)*0.05;
		}else if (lirun>40&&lirun<=60) {
			jj=10*0.1+10*0.75+20*0.05+(lirun-40)*0.03;
		}else if (lirun>60&&lirun<=100) {
			jj=10*0.1+10*0.75+20*0.05+20*0.03+(lirun-60)*0.015;
		}else if (lirun>100) {
			jj=10*0.1+10*0.75+20*0.05+20*0.03+40*0.015+(lirun-100)*0.01;
		}
    	System.out.println("提成为"+jj+"万元");
    }
}