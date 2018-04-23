/**
 * Created by Autumn on 2018/4/23.
 */
public class Main {
    public static void main(String[] args) {
        Aggregate agg = new ConcreteAggregate();
        agg.add("张三");
        agg.add("李四");
        agg.add("王五");
        //遍历
        Iterator iterator = agg.creatIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
