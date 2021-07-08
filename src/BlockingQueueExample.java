import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class BlockingQueueExample {

	public static void main(String[] args) {
		
		BlockingQueue<String> myQueue = new ArrayBlockingQueue<String>(5);
		MyProducer thread1 = new MyProducer(myQueue);
		MyConsumer thread2 = new MyConsumer(myQueue);
		MyProducer thread3 = new MyProducer(myQueue);
		MyProducer thread4 = new MyProducer(myQueue);
		MyProducer thread5 = new MyProducer(myQueue);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		
	}

}


class MyProducer extends Thread{

	BlockingQueue blockingQueue;
	
	MyProducer(BlockingQueue blockingQueue){
		this.blockingQueue = blockingQueue;
	}
	
	@Override
	public void run() {
		try {
			blockingQueue.put(Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}


class MyConsumer extends Thread{

	BlockingQueue blockingQueue;
	
	MyConsumer(BlockingQueue blockingQueue){
		this.blockingQueue = blockingQueue;
	}
	
	@Override
	public void run() {
		String threadName = null;
		try {
			while(true){
			threadName = (String) blockingQueue.take();
			System.out.println(threadName);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
 