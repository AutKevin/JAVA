public class Arithmetic_zhiShu{
    public static void main(String[] args){
        int start = 1;
        int end = 100;
        if(args!=null&&args.length>=2){
            start = Integer.parseInt(args[0]);
            end = Integer.parseInt(args[1]);
        }
        int count = 0;
        System.out.println("从"+start+"循环到"+end);
        for(int i =start;i<=end;i++){
            if(isZhiShu(i)){
                System.out.println(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isZhiShu(int num){
         //System.out.println("第"+num);
        if(num==2){
            return true;
        }
        if(num<2||num%2==0){    //2是最小的整数,所以小于2和能被2整除的都不是质数
            return false;
        }
        
        for(int i =3;i<Math.sqrt(num);i=i+2){    //从三开始一直到num的开根的所有奇数(偶数一定不是质数,所以全部取奇数.开根是因为一个数的)
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}