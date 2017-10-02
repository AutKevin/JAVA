public class Arithmetic_rabbit{
    public static void main(String[] args){
        int index =10;
        if(args!=null&&args.length>0){
            index = Integer.parseInt(args[0]);
        }
        
        //从第一个月开始
        int i = 1;
        while(getNum(i)<index){
            i++;
        }
        System.out.println(index+"只兔子,至少需要"+(i)+"个月");
        /*查看每个月兔子的数量
        for(int i=1;i<=index;i++){
            System.out.println("第"+i+"个月,有"+getNum(i));   
        }*/
    }
    //递归,根据上个月的兔子和这个月即将生的兔子获得这个月兔子的总和
    public static int getNum(int month){
        if(month==1||month==2){
            return 1;
        }else{
            return getNum(month-1)+getNum(month-2);
        }
    }
}