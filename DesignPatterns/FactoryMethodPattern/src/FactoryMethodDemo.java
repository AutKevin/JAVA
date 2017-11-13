import com.qy.impl.ConcreteCreator;
import com.qy.impl.ConcreteProduct;
import com.qy.intf.Creator;
import com.qy.intf.Product;


public class FactoryMethodDemo {

	public static void main(String[] args) {
		Creator creator = new ConcreteCreator();    //生成某个工厂(能生产某个接口子类的工厂,这里是实例化一个生产Produt子类的工厂)
		Product product = creator.factory(ConcreteProduct.class);    //工厂根据具体的类(实现特定接口的,这里是Product接口)生成实例;
		product.method1();
		product.method2();
	}

}
