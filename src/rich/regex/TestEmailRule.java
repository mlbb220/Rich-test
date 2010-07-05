package rich.regex;

import org.junit.Test;

import junit.framework.Assert;

public class TestEmailRule {

	@Test
	public void testRule(){
		String mailRule = "\\w+(\\.\\w+)*@\\w+(\\.\\w+)+";
		Assert.assertTrue("1@1.1".matches(mailRule));
		Assert.assertTrue("1.1@1.1".matches(mailRule));

		Assert.assertFalse("1%%@1.1".matches(mailRule));
		Assert.assertFalse("1==@1.1".matches(mailRule));
		Assert.assertFalse("1++@1.1".matches(mailRule));
		Assert.assertFalse("13@.@1.1".matches(mailRule));
		Assert.assertFalse("1$$@1.1".matches(mailRule));
		
	}
}
