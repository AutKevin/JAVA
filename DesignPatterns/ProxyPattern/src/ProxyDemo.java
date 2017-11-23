import com.qy.impl.ProxySubject;
import com.qy.impl.RealSubject;
import com.qy.inf.Subject;


public class ProxyDemo {
	public static void main(String[] args) {
		Subject subject = new RealSubject();
		System.out.println(subject.toString()+"未代理前执行request请求:------------------------");
		subject.request();
		System.out.println("代理后执行request请求:--------------------------");
		subject = new ProxySubject(subject);
		subject.request();
	}
}
