
public class MyCountDownLatch {
	
	public final Object syncObject = new Object(); 
	int counter;
	
	MyCountDownLatch(int counter){
		this.counter = counter;
	}

	public void await() throws InterruptedException{
		synchronized(syncObject){
			if(counter != 0){
				syncObject.wait();
			}
		}
	}
	
	
	public void countDown(){
		synchronized(syncObject){
			counter -- ;
			if(counter == 0){
				syncObject.notifyAll();
			}
		}
	}
}
