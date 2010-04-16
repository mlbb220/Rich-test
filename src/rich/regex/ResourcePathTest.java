package rich.regex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import junit.framework.TestCase;


/**
 * @author Rich.Li
 *
 */
public class ResourcePathTest extends TestCase
{

  public void test(){
    String xmlPath = this.getClass().getResource("/").getPath()+"/rich/regex/";
    String xmlName = "childsupportExtFileAccountMaintenance.xml";
    String fileName = xmlPath+xmlName;
    File temp = new File(fileName);
    
    try {
		System.out.println(new BufferedReader(new InputStreamReader(new FileInputStream(temp))).readLine());
	} catch (Exception e) {
		fail("exception happens"+e);
	}
    System.out.println(this.getClass().getResource("/").toExternalForm());
    System.out.println(this.getClass().getResource("."));
    System.out.println(this.getClass().getResource("./"));
  }

}

