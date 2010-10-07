package rich.calendar;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

public class TestWeekDays {

	@Test
	public void dayOfWeek(){
		Calendar c = Calendar.getInstance();
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
		System.out.println(java.util.Calendar.getInstance().get(java.util.Calendar.DATE));
	}
	
	@Test
	public void dateFormat(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
		ParsePosition position = new ParsePosition(0);
		String actual = "$201010#";
		Date effectiveDate = formatter.parse(actual, position);
		System.out.println("effectiveDate is : " + effectiveDate);
		System.out.println("position is : " + position);
		Assert.assertNull(effectiveDate);
	}
}
