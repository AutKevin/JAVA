public class Arithmetic_FenJie{

    public static void getNumber(int number){
        int a = 2;
        System.out.print(number + "=");
        while(number > a){      //确保分解的数大于2,不然没有意义
            if(number % a == 0){    //查看待分解数是否能被a整除
                System.out.print(a + "*");    //能整除,则打印出来
                number = number / a;    //number的值为除以a后剩下的数
            }else{
                a++;    //a自加一
            }
        }
        System.out.print(a);
    }

    public static void main(String[] args) {
        getNumber(Integer.parseInt(args[0]));
    }
}