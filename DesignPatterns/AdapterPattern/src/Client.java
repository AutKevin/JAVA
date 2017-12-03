import com.qy.impl.Adapter;
import com.qy.inf.Target;


public class Client {
	public static void main(String[] args) {
		Target target = new Adapter();
		target.request();
	}
}
