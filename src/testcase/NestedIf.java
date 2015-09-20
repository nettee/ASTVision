package testcase;

public class NestedIf {

	public static void main(String[] args) {

		int a = 1;
		
		if (a > 0) {
			if (a > 3) {
				if (a > 6) {
					System.out.println("a > 6");
				} else {
					System.out.println("3 < a <= 6");
				}
			} else {
				System.out.println("0 < a <= 3");
			}
		} else {
			System.out.println("a <= 0");
		}
		
	}

}
