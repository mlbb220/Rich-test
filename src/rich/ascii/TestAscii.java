package rich.ascii;

import junit.framework.Assert;

import org.junit.Test;

public class TestAscii {

	@Test
	public void test(){
		char a = '-';
		System.out.println((byte)a);
		a = '-';
		System.out.println((byte)a);
		byte newbyte = 95;
		System.out.println((char)newbyte);
		
	}
	
	@Test
	public void printBoolean(){
		Assert.assertTrue(true&& true);
		Assert.assertFalse(true&& false);
		Assert.assertFalse(false && true);
		int a = 1;
		Assert.assertFalse(true&&((a++) == 2) );
		Assert.assertFalse(false&&((a++) == 2) );
		System.out.println("a is :"+a);
	}
}
