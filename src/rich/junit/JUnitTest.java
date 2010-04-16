package rich.junit;

import org.junit.*;

import junit.framework.TestCase;
import junit.framework.TestSuite;


public class JUnitTest extends TestCase {

	@BeforeClass
	public static void setUp1(){
		System.out.println("i'm in setup");
	}
	
	@Test
	public void test1(){
		System.out.println("i'm in test1");
	}
	@Test
	public void test2(){
		System.out.println("i'm in test2");
	}
	@Test
	public void test3(){
		System.out.println("i'm in test3");
	}
	@Test
	public void test4(){
		System.out.println("i'm in test4");
	}
	
	public static void main(String[] args){
		TestSuite ts = new TestSuite();
		ts.addTestSuite(JUnitTest.class);
		junit.textui.TestRunner.run(ts);
//		junit.swingui.TestRunner.run(JUnitTest.class);		
	}
}

