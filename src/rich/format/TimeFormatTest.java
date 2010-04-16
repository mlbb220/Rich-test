
package rich.format;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

/**
 * @author Rich.Li
 * 
 */
public class TimeFormatTest extends TestCase {

	public void testTime() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		String format = "yyMMddHHmm";
		SimpleDateFormat sp = new SimpleDateFormat(format);
		System.out.println(sp.format(c.getTime()));

	}

}
