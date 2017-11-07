public class Arithmetic_pingfangshu{
    public static void main(String[] args){
		//一个整数，它加上100后是一个完全平方数，加上168又是一个完全平方数，请问该数是多少？ 
        for(int i=0;i<=100000;i++){
			if(Math.sqrt(i+100)%1==0&&Math.sqrt(i+268)%1==0){
				System.out.println(i);
			}
		}
    }
}