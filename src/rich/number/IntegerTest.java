package rich.number;

import org.junit.Test;

public class IntegerTest{

	@Test
	public void testTohex(){
		int a = 120;
		System.out.println(Integer.toHexString(a));
		System.out.println(Integer.toBinaryString(a));
		byte b = '0';
		StringBuffer sb = new StringBuffer();
		sb.append(Integer.toHexString((b & 0xf0) >>> 4));
		sb.append(Integer.toHexString(b & 0x0f));
		System.out.println("b result is : " +sb.toString());
	}
}
