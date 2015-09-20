package testcase;

public class Recursion {
	
	public static long factorial(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

}
