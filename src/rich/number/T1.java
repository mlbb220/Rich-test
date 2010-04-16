
package rich.number;

import java.util.Vector;

/**
 * @author Rich.Li
 *
 */
public class T1
{

  /**
   * @param args
   */
  public static void main(String[] args)
  {
	  double test = 1111111265.50;
	  System.out.println(test);
    testMath();
    Vector a = new Vector();
    a.add(null);

  }
  private static void testMath(){
    int a = 100;
    int b = 15;
    System.out.println(a/b);
    System.out.println(a | b);
    System.out.println(a % b);
  }
}
