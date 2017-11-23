import com.qy.impl.ConcreteComponent;
import com.qy.inf.Component;
import com.qy.inf.ConcreteDecorator;


public class DecoratorDemo {
	public static void main(String[] args) {
		Component component = new ConcreteComponent();
		component.operation();
		System.out.println("经过装饰----------");
		component = new ConcreteDecorator(component);
		component.operation();
	}
}
