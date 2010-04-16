package rich.thread;

public class ThreadRunning  implements Runnable{

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		while(true){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("sleep 2s~~");
		}

	}

	@Override
	public void run() {
		new Thread(new ThreadRunning()).start();
		
	}

}
