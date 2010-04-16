package rich.calendar;

import java.util.Calendar;

import org.junit.Test;

public class TestWeekDays {

	@Test
	public void dayOfWeek(){
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime().getDay());
	}
}
