
public class MemoryAnalyse {
	public static int k = 0;
	public static MemoryAnalyse t1 = new MemoryAnalyse("t1");
	public static MemoryAnalyse t2 = new MemoryAnalyse("t2");
	public static int i = print("i");
	public static int j = print("j");
	public static int n = 99;
	
	{
		print("constructor code");
	}
	
	static {
		print("static code");
	}

	public static int print(String s) {
		System.out.println("i=" + i + "   " + s + "  k=" + k + "  n=" + n
				+ "   j=" + j);
		++i;
		++k;
		++n;
		return i;
	}

	public MemoryAnalyse(String string) {
		print(string);
	}

	public static void main(String[] args) throws ClassNotFoundException {
		MemoryAnalyse d = new MemoryAnalyse("T");
		//Class.forName("MemoryAnalyse");
	}
}
