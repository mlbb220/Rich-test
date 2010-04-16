package rich.innerclass;

public class TestInnerClass {

	public static void main(String[] args) {
		InnerFace face = new InnerFace(){
			public void face(){
				
			}
		};
		
	}
}

interface InnerFace{
	void face();
}