import com.qy.inf.Prototype;

public class Client {
	public void operation(Prototype example) {
		//得到example
		Prototype prototype = example.clone();
		System.out.println(prototype);
	}
}