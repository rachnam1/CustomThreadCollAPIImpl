
public class MySemaphore {
	
	public int counter;
	
	MySemaphore(int counter){
		this.counter = counter;
	}
	
	public  synchronized void acquire() throws InterruptedException{
		if(counter == 0){
			wait();
		}
		counter --;
	}
	
	public  synchronized  void release() throws InterruptedException{
		if(counter == 0){
			counter ++;
			notifyAll();
		}else{
			counter++;
		}
		
	}

}
