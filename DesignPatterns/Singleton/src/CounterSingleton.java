
public class CounterSingleton {
	private static CounterSingleton singleton = new CounterSingleton();
	
	private CounterSingleton() {
	}
	
	public static CounterSingleton getInstance() {
		return singleton;
	}
	//对象的私有成员
	private int count = 0;
	 
    public synchronized void inc() {        
        //加访问量
        count++;
        System.out.println(count);
    }

	public int getCount() {
		return count;
	}
    
}
