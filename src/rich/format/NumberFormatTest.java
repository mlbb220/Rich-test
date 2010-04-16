package rich.format;

import java.text.NumberFormat;

import junit.framework.TestCase;

/**
 * @author Rich.Li
 *
 */
public class NumberFormatTest extends TestCase
{

  public void testFormat()
  {
    NumberFormat n = NumberFormat.getCurrencyInstance();
    System.out.println(n.format(20012345.23));
    
    NumberFormat nf = NumberFormat.getCurrencyInstance();
    System.out.println(nf.format(45.23));
    System.out.println(nf.format(145.23));
    System.out.println(nf.format(1111145.23));

    String AMOUNT_FORMAT = "0,000.00";
    double dbl = 11.12;
    java.text.NumberFormat formatter = new java.text.DecimalFormat(AMOUNT_FORMAT);
    String rtn = "";
    rtn = formatter.format(dbl);
    System.out.println(rtn);
    System.out.println(Double.MAX_VALUE);
  }

}
