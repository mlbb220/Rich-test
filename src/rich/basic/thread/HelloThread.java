package rich.basic.thread;

public class HelloThread implements Runnable {

	String name = "HelloThread";
	
	public HelloThread(){
	}
	
	public HelloThread(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println(this.getClass().getName() + " :HelloThread name is :" + this.name );
		
	}
	

	
}
