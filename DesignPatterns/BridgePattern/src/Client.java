import com.qy.impl.ConcreteImplementor;
import com.qy.impl.RefinedAbstraction;
import com.qy.inf.Abstraction;
import com.qy.inf.Implementor;

//调用
public class Client {
	public static void main(String[] args) {
		//定义一个实现化角色
		Implementor imp = new ConcreteImplementor();
		//定义一个抽象化角色
		Abstraction abstraction = new RefinedAbstraction(imp);
		abstraction.operation();
	}
}
