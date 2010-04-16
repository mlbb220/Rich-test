package rich.format;

import junit.framework.TestCase;

public class SwitchTest extends TestCase {

	public void testSwitch() {
		int a = 4;

		switch (a) {
		case 1:
			System.out.println(1);
		case 2:
			System.out.println(2);
		case 3:
			System.out.println(3);
		default:
			break;
		}

	}

}
