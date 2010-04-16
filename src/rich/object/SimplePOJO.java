package rich.object;

public class SimplePOJO {

	String test ="";
	int aInt = 1;
	
	public SimplePOJO() {
		// TODO Auto-generated constructor stub
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public int getaInt() {
		return aInt;
	}

	public void setaInt(int aInt) {
		this.aInt = aInt;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("int is :" + aInt + "  ");
		sb.append("test is :" + test +"\r\n");
		return sb.toString();
	}

	
	
}
