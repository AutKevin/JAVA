import java.util.Scanner;

public class Arithmetic_score{
    //题目：利用条件运算符的嵌套来完成此题：学习成绩> =90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
        System.out.println("请输入成绩：");
        int N = in.nextInt();
        socerType(N);
	}

	public static void socerType(int n) {
	char result = '0';
        result = n>=90?'A':(n<60?'C':'B');
        //切勿写成n>=90?result='A':(n<60?result='C':result='B'); //三元运算符也是返回一个值的
        System.out.println(result);
    }
}