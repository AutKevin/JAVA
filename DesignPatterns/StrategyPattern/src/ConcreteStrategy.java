/**
 * 具体策略类
 */
public class ConcreteStrategy extends Strategy {
    //实现策略方法
    @Override
    public void strategyInterface() {
    //具体算法
        System.out.println("具体策略算法");
    }
}
