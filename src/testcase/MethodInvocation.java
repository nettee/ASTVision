package testcase;

public class MethodInvocation {
	
	public static int alice(int a) {
		return a + 1;
	}
	
	public static int bob(int a) {
		return a + 2;
	}
	
	public static int claire(int a) {
		return a + 3;
	}
	
	public static int david(int a) {
		return a + 4;
	}

	public static void main(String[] args) {
		int a = 0;
		a = alice(a);
		a = bob(a);
		a = claire(a);
		a = david(a);
		System.out.println(a);
	}

}
