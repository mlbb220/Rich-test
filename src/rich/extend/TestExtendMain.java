
package rich.extend;

/**
 * @author Rich.Li
 *
 */
public class TestExtendMain
{

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

    FClass f = new FClass();
    FClass child = new ChindClass();
    f.testResult();
    f.testFinalString();
    child.testResult();
    child.testFinalString();
  }

}
