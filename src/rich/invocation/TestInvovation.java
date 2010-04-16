package rich.invocation;

import java.lang.reflect.Constructor;

import junit.framework.TestCase;

public class TestInvovation extends TestCase {

	public void testIn() {
		try {
			String dataType = "java.lang.Long";
			String valueStr = "00000002";
			Class cls = Class.forName(dataType);

			Constructor ct = null;
			Object arglist[] = null;
			// handle classes that need to be supported but do not have a string
			// constructor
			if (dataType.equals(Character.class.getName())) {
				Class partypes[] = new Class[] { Character.TYPE };
				ct = cls.getConstructor(partypes);
				arglist = new Object[] { new Character(valueStr.charAt(0)) };
			} else {
				Class partypes[] = new Class[] { String.class };
				ct = cls.getConstructor(partypes);
				arglist = new Object[] { valueStr };
			}

			Object obj = ct.newInstance(arglist);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
			assertNull(e);
		}
	}
}
