package rich.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.TestCase;

public class TestRegexPatten extends TestCase {

	public void TestRegex() {
		String str = "For my money, the important thing "
				+ "about the meeting was bridge-building";
		String regEx = "a|f";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		boolean result = m.find();
		System.out.println(result);
	}

}
