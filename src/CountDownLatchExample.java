import java.util.concurrent.CountDownLatch;


public class CountDownLatchExample {

	public static void main(String args[]){
		MyCountDownLatch countDownLatch = new MyCountDownLatch(2);
		
		MyThread thread1 = new MyThread(countDownLatch);
		MyThread thread2 = new MyThread(countDownLatch);
		MyThread thread3 = new MyThread(countDownLatch);
		MyThread thread4 = new MyThread(countDownLatch);
		MyThread thread5 = new MyThread(countDownLatch);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		
		try {
			countDownLatch.await();
			
			System.out.println("Main thread execution after all threads");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class MyThread extends Thread{
	MyCountDownLatch countDownLatch;
	
	MyThread(MyCountDownLatch countDownLatch){
		this.countDownLatch = countDownLatch;
	}
	
	public void run(){
		System.out.println("Execution start of" + Thread.currentThread().getName());
		countDownLatch.countDown();
		
	}
}