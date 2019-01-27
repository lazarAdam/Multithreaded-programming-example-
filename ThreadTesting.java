import java.awt.List;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTesting extends Thread{

	private ReentrantLock cslock = new ReentrantLock();
	
	private ArrayList<Integer> l = new ArrayList<Integer>();
	
	private int counter = 0;
	
	public  void  run(){
	
		while (counter < 100){
			
			cslock.lock();
			
		
			System.out.println(counter++);
			
			cslock.unlock();
			
			
			try {
				
			
				
				
				
				Thread.sleep(500);
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	
	
	}
	

	

	
	public int print() {
		
		return this.counter;
	}



	public static void main(String[] args) throws InterruptedException {
	
		ThreadTesting test = new ThreadTesting(); 
		
		
		int numberOfThreads = 5;
		Thread[] threads = new Thread[numberOfThreads];
		for (int index = 0; index < threads.length; index++) {
		threads[index] = new Thread(test);
		threads[index].start();
		
		
		}
		

		try {
			
			for (int index = 0; index < threads.length; index++) {
			threads[index].join();
			}
			} catch(InterruptedException ie) {
			ie.printStackTrace();
			}
			
		//System.out.println(test.print());
	}

}
