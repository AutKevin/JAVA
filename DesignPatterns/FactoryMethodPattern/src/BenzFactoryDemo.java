import com.qy.BenzImpl.BenzC180;
import com.qy.BenzImpl.BenzC180Factory;
import com.qy.BenzImpl.BenzE260;
import com.qy.BenzImpl.BenzE260Factory;
import com.qy.BenzImpl.BenzFactoryImpl2;
import com.qy.BenzIntf.Benz;
import com.qy.BenzIntf.BenzFactory;
import com.qy.BenzIntf.BenzFactory2;


public class BenzFactoryDemo {

	public static void main(String[] args) {
		Benz benz = null;
		//为每一种产品类建一个工厂
		/*BenzFactory benzFactory = new BenzE260Factory();
		benz = benzFactory.create();*/
		//使用第二种方法创建
		BenzFactory2 bFactory2 = new BenzFactoryImpl2();
		benz = bFactory2.createFactory(BenzE260.class);
		benz.carColor();
		benz.carPrice();
		benz.carSpeed();
	}

}
