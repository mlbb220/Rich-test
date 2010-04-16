
package rich.extend;

/**
 * @author Rich.Li
 *
 */
public class FClass
{

  protected static final String FILENAME="testin father class";
  protected String testString;
  public FClass(){
    testString = "fClass";
  }
  
  public void testResult(){
    System.out.println(testString);
  }
  
  public void testFinalString(){
    System.out.println(FILENAME);
  }
}
