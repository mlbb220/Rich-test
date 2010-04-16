package rich.basic.file;

import java.io.File;

import org.junit.Test;

public class TestFileExist{

	@Test
	public void testExist(){
		String filePath = "2010032502.testfile";
		File file = new File(filePath);
		System.out.println(file.exists());
	}
	
}
