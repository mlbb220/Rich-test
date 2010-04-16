package rich.number;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.StringTokenizer;

import junit.framework.TestCase;

public class NumberTest extends TestCase {

	int testNumber;
	String test;

	public void setUp() {
		testNumber = 1;
		test = "";
	}

	public void testMain1() {
		URL url = NumberTest.class.getResource("./");
		URL url2 = NumberTest.class.getResource("/");
		String test = "a";
		int ss = 1;
		System.out.println(url);
		System.out.println(url2);

		int size = 101;
		NumberFormat nf = new DecimalFormat("000000000");
		String record_count = nf.format(size);
		System.out.println(record_count);

		Calendar c = Calendar.getInstance();
		System.out.println(c);
	}

	public void testString() {
		String guide = "section508;,wcg2001";
		StringTokenizer st = new StringTokenizer(guide, ";,                  ");
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

}