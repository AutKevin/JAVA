import com.facade.demo.Secretary;

//老板调用外观角色(秘书)
public class Boss {
	public static void main(String[] args) {
		Secretary secretary = new Secretary();
		System.out.println("老板告诉秘书要到美国出差10天");
		secretary.travel("美国", 10);
	}
}
