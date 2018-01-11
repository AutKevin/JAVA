import com.qy.impl.FlyweightFactory;

//调用
public class textFlyweight {
	public static void main(String[] args) {
		System.out.println(FlyweightFactory.getFlyweight("1"));
		System.out.println(FlyweightFactory.getFlyweight("1"));
		System.out.println(FlyweightFactory.getFlyweight("2"));
		System.out.println(FlyweightFactory.getFlyweight("3"));
	}
}
