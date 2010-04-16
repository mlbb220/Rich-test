
package rich.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;

import junit.framework.TestCase;

/**
 * @author Rich.Li
 * 
 */
public class ReadFileTest extends TestCase
{

  /*
   * (non-Javadoc)
   * 
   * @see junit.framework.TestCase#setUp()
   */
  protected void setUp() throws Exception
  {
    // TODO Auto-generated method stub
    super.setUp();
  }

  /*
   * (non-Javadoc)
   * 
   * @see junit.framework.TestCase#tearDown()
   */
  protected void tearDown() throws Exception
  {
    // TODO Auto-generated method stub
    super.tearDown();
  }

  public void testReadInt() throws Exception
  {
    String filePath = this.getClass().getResource("/").getPath() + "rich/file/";
    String processFileName = filePath + "MAUI20090615164432202ACCTMAINT";
    InputStream is = new FileInputStream(new File(processFileName));
    int result = -1;
    int num = 0;
    while((result = is.read())!= -1)
    {
      System.out.print(result);
//      System.out.print(Integer.toHexString(result));
      num++;
      if(num % 230 == 0) System.out.println("");
    }
    System.out.print(Integer.toHexString(13));
    System.out.print(Integer.toHexString(10));
    System.out.println(num);

  }
  
  public void testReadChar() throws Exception
  {
    String filePath = this.getClass().getResource("/").getPath() + "rich/file/";
    String processFileName = filePath + "MAUI20090615164432202ACCTMAINT";
    InputStream is = new FileInputStream(new File(processFileName));
    int result = -1;
    int num = 0;
    while((result = is.read())!= -1)
    {
      System.out.print((char)result);
      num++;
    }
    System.out.println(num);

  }
  
  public void testReadOx() throws Exception
  {
    String filePath = this.getClass().getResource("/").getPath() + "rich/file/";
    String processFileName = filePath + "MAUI20090615164432202ACCTMAINT";
    InputStream is = new FileInputStream(new File(processFileName));
    int result = -1;
    int num = 0;
    while((result = is.read())!= -1)
    {
      System.out.print(Integer.toHexString(result));
      num++;
      if(num % 230 == 0) System.out.println("");
    }
    System.out.println(num);

  }

  public void testReadFileLength() throws Exception
  {
	
    String filePath = this.getClass().getResource("/").getPath() + "rich/file/";
    String processFileName = filePath + "OKUI20091218165432202ACCTMAINT";
    
    RandomAccessFile raf = new RandomAccessFile(new File(processFileName),"r");
    System.out.println("OKUI20091218165132202ACCTMAINT length is :"+raf.length());
    System.out.println("OKUI20091218165132202ACCTMAINT length is :"+(raf.length()%332));
  }
}

