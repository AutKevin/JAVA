/*打印出所有的 "水仙花数 "，所谓 "水仙花数 "是指一个三位数，其各位数字立方和等于该数本身。例如：153是一个 "水仙花
数 "，因为153=1的三次方＋5的三次方＋3的三次方。*/
public class Arithmetic_daffodil{
    public static void main(String[] args){
        for(int i=100;i<=999;i++){
            if(isDaffodial(i)){
                System.out.println(i); 
            }
        }
    }

    public static boolean isDaffodial(int num){
        int single = num%10;
        int ten = (num/10)%10;
        int hundred = (num/100)%10;
        /*System.out.println(num);
        System.out.println(single);
        System.out.println(ten);
        System.out.println(hundred);
        System.out.println("总和:"+(single*single*single+ten*ten*ten+hundred*hundred*hundred)); 
        */
        if((single*single*single+ten*ten*ten+hundred*hundred*hundred)==num){
            return true;
	}
        return false;
    }
}