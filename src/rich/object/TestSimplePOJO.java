package rich.object;

import junit.framework.TestCase;

public class TestSimplePOJO extends TestCase{

	public void rtestRefrence(){
		SimplePOJO pojo = new SimplePOJO();
		System.out.println("before: "+pojo);
		changePOJO(pojo);
		System.out.println("after: "+pojo);
	}
	
	public void testRefrenceNull(){
		SimplePOJO pojo = null;
		System.out.println("before: "+pojo);
		changePOJO(pojo);
		System.out.println("after: "+pojo);
	}
	
	private void changePOJO(SimplePOJO pojo){
		System.out.println("before change: "+pojo);
		if(pojo == null)
			pojo = new SimplePOJO();
		pojo.setaInt(1234);
		pojo.setTest("test string");
		System.out.println("after change: "+pojo);
	}
}
