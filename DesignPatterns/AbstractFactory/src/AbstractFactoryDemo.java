import com.qy.AbstractFactoryI.IBook;
import com.qy.AbstractFactoryI.IFactory;
import com.qy.AbstractFactoryI.IGame;
import com.qy.AbstractFactoryI.IProduct;
import com.qy.AbstractFactoryImpl.Factory;
import com.qy.AbstractFactoryImpl.FactoryAnother;


public class AbstractFactoryDemo {
	public static void main(String[] args) {
		//IFactory fc = new Factory();
		//要想生成另一组实例只需要更换具体工厂即可.
		IFactory fc = new FactoryAnother();
		IBook book = fc.createBook();
		IGame game = fc.createGame();
		IProduct product = fc.createProduct();
		book.method1();
		game.method1();
		product.method1();
	}
}
