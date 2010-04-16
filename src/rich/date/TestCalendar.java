package rich.date;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

public class TestCalendar extends TestCase {

	
	public void testDate(){
		int days = 24;
		Calendar c = Calendar.getInstance();
//		c.set(2009, 12, 28);
		System.out.println(c.getTimeInMillis());
		System.out.println(System.currentTimeMillis());
		System.out.println(new Date(System.currentTimeMillis()));
		System.out.println(new Date(c.getTimeInMillis()));
		System.out.println("ms is :\n"+ (c.getTimeInMillis() - 24*3600*1000*days));
		System.out.println(new Date(c.getTimeInMillis() - 24*3600*1000*days));
		System.out.println(24*3600*1000*days);
		System.out.println("ms is :\n"+ (c.getTimeInMillis() - 24*3600*1000*(days+1)));
		System.out.println(new Date(c.getTimeInMillis() - 24*3600*1000*(days+1)));
		System.out.println(24*3600*1000*(days+1));
	}
}
