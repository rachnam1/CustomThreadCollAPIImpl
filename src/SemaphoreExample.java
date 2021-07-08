import java.util.concurrent.Semaphore;


public class SemaphoreExample extends Thread {
	
	
	MySemaphore semaphore;
	
	SemaphoreExample(MySemaphore semaphore){
		this.semaphore = semaphore;
	}
	
	public static void main(String[] args) {
		MySemaphore mySemaphore = new MySemaphore(2);
		
		SemaphoreExample thread1 = new 	SemaphoreExample(mySemaphore);
		SemaphoreExample thread2 = new 	SemaphoreExample(mySemaphore);
		SemaphoreExample thread3 = new 	SemaphoreExample(mySemaphore);
		SemaphoreExample thread4 = new 	SemaphoreExample(mySemaphore);
		SemaphoreExample thread5 = new 	SemaphoreExample(mySemaphore);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
	}
	
	
	public void run() {
		try {
			semaphore.acquire();
			System.out.println("Lock acquired" + Thread.currentThread().getName());
			
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				semaphore.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Lock released");
		}
		
		
		
	}

}
