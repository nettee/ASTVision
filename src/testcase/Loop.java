package testcase;

public class Loop {

	public static void main(String[] args) {

		int s = 0;
		int x = 1;
		while (x < 10) {
			s += x;
			x++;
		}
		
		for (int i = 0; i < 10; i++) {
			s += i;
		}
		
		x = 1;
		do {
			s += x;
			x++;
		} while (x <= 10);
		
		
	}

}
