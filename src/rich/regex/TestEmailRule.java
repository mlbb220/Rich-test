package rich.regex;

import org.apache.regexp.RE;
import org.junit.Test;

import junit.framework.Assert;

public class TestEmailRule {

	@Test
	public void testRule(){
//		String mailRule = "\\w+(\\.\\w+)*@\\w+(\\.\\w+)+";
		String mailRule = "^[\\w-_\\.]*[\\w-_\\.]\\@[\\w]\\.+[\\w]+[\\w]$";
//		String mailRule = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		Assert.assertTrue("ir@w.wo".matches(mailRule));
		Assert.assertTrue("1.1@1.1e".matches(mailRule));
		Assert.assertTrue("a111@a.com".matches(mailRule));
		Assert.assertTrue("1ri.1ch1@1.com".matches(mailRule));
		Assert.assertTrue("1ri.1ch1@163.com".matches(mailRule));

		Assert.assertFalse("1%%@1.1".matches(mailRule));
		Assert.assertFalse("1==@1.1".matches(mailRule));
		Assert.assertFalse("1++@1.1".matches(mailRule));
		Assert.assertFalse("13@.@1.1".matches(mailRule));
		Assert.assertFalse("1$$@1.1".matches(mailRule));
		
	}
	
	@Test
	public void testReRule(){
		RE testRule = new RE("^[\\w-_\\.]*[\\w-_\\.]\\@[\\w]\\.+[\\w]+[\\w]$");
		Assert.assertTrue(testRule.match("rich.li@1.com"));
	}
}
