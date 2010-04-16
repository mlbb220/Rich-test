package rich.collections;

import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

public class TestProperties {

	@Test
	public void testProperties(){
		Properties p = new Properties();
		String fileName = "test.properties";
		try {
			p.load(this.getClass().getResourceAsStream(fileName));
			System.out.println(p.get("key1"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
