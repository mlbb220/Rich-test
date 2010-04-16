package rich.thread;

public class TestThread {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new TestThread();

    }

    public String a = "test";

    public TestThread() {
        Thread thread1 = new WaitThread("thread1");
        Thread thread2 = new WaitThread("thread2");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.start();
        thread1.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Thread thread3 = new NotifyThread();
        thread3.start();

    }

    class WaitThread extends Thread {
    	
    	
        public WaitThread(String name) {
        	super(name);
		}

		public void run() {
            synchronized (a) {
                try {
                    System.out.println("before wait : " + Thread.currentThread() + ":" + a);
                    a.wait();
                    System.out.println("after wait : " + Thread.currentThread() + ":" + a);
                    System.out.println("before sleep : " + Thread.currentThread() + ":" + a);
                    sleep(1000);
                    System.out.println("after sleep : " + Thread.currentThread() + ":" + a);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    class NotifyThread extends Thread {
        public void run() {
        	System.out.println("NotifyThread works");
            synchronized (a) {
                a.notifyAll();
            }
        }
    }
}
