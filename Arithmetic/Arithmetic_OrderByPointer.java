public class Arithmetic_OrderByPointer {
	public static void main(String[] args) {
		int[] arrays = { 800, 56, 500 };
		for (int i = arrays.length; --i >= 0;) {
			for (int j = 0; j < i; j++) {
				if (arrays[j] > arrays[j + 1]) {
					int temp = arrays[j];
					arrays[j] = arrays[j + 1];
					arrays[j + 1] = temp;
				}
			}
		}
		for (int n = 0; n < arrays.length; n++)
			System.out.println(arrays[n]);
	}
}
