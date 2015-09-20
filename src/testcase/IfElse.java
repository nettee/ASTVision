package testcase;

public class IfElse {

	public static void main(String[] args) {

		int a = 1;
		if (a > 0) {
			System.out.println("a > 0");
		}
		
		int b = 1;
		if (b > 0) {
			System.out.println("b > 0");
		} else {
			System.out.println("b <= 0");
		}
		
		int c = 1;
		if (c > 0) {
			System.out.println("c > 0");
		} else if (c < 0) {
			System.out.println("c < 0");
		} else {
			System.out.println("c == 0");
		}
		
		
		
	}

}
