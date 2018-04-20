/**
 * 环境角色类
 */
public class Context {
    private Strategy strategy = null;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    //调用策略方法
    public void contextInterface(){
        this.strategy.strategyInterface();
    }

    /**
     * 测试方法
     */
    public static void main(String[] args) {
        Strategy strategy = new ConcreteStrategy();   //实例化一个策略类,此处可替换为其他策略
        Context context = new Context(strategy);    //环境类封装策略类
        context.contextInterface();    //环境类调用方法
    }
}
