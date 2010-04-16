package rich.number;

import junit.framework.TestCase;

/**
 * @author Rich.Li
 * 
 */
public class LongTest extends TestCase {

	public void testLong() {

		int testInt = 123456789;
		System.out.println(testInt);
		System.out.println(testInt % 100000);

		double testDouble = 11.02;
		System.out.println(FormatDouble(testDouble, "000000000"));

		System.out.println(Integer.MAX_VALUE);

		long testNumber = 62;
		System.out.println(new Long(testNumber++));
		System.out.println(new Long(testNumber++).toString());

		System.out.println(Long.MAX_VALUE);
		String test = "2000000000372000037200037";
		System.out.println(test);
		try {
			Long a = new Long(test);
			System.out.println(a);
			fail("There should be a NumberFormatException");
		} catch (NumberFormatException e) {
			assertNotNull(e);
		}
		
		System.out.println("Character.MIN_RADIX is :" + Character.MIN_RADIX);
		System.out.println("Character.MAX_RADIX is :" + Character.MAX_RADIX);
		System.out.println("Long.MAX_VALUE is :"+Long.toString(Long.MAX_VALUE));
		System.out.println("Long.MAX_VALUE based on 16 iis :"+Long.toString(Long.MAX_VALUE,18));
	}

	public static String FormatDouble(double dbl, String form) {
		java.text.NumberFormat formatter = new java.text.DecimalFormat(form);
		String rtn = "";
		rtn = formatter.format(dbl);
		return rtn;
	}

}
