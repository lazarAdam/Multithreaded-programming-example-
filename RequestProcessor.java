
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class will Orchestrate most of the work done by the threads
 * use threads to process each string in the queue
 * use the concept of concurrency in multithreading by deploying locks and local thread variables
 * @author Oussama
 *
 */
public class RequestProcessor extends Thread  {

	
	private ThreadLocal <ThreadStatsticSetup>threadss = new ThreadLocal<ThreadStatsticSetup>();// use of a ThreadLocal object
	private ReentrantLock cslock = new ReentrantLock();// use of ReentrantLock lock object
	private LinkedQueue<String> strQueue = new LinkedQueue<String>(); // generic queue object
	
	
	
	/**
	 *  A Constructor that takes a collection of strings from the driver
	
	 * @param collection
	 */
	RequestProcessor( LinkedQueue<String> collection ){
		
		this.strQueue = collection;
	}
	
	
	
	/**
	 * Run method form the thread class in which every thread will execute 
	 * call threadstatsicSetup constructor to make a threadStatic object for each thread 
	 * process each string in the queue by removing it 
	 * adding it's length to accumulated length
	 * increment the count
	 */
	public void run(){
		
		//the key to have each tread work on their own is to make each with two local variables length and  totalCount
		//after a thread goes through the CS it will update it own area using the threadLocal variables for count and length 
		
		
		// local variables for each Thread 
		int length = 0;
		int totalCount =0;
		
		this.cslock.lock();// using this lock to ensure that  every thread will get a ThreadStatstic object
		
		try{	
			
		this.threadss.set( new ThreadStatsticSetup()); // using LocalThreread variable to contain a ThreadStatsticsetup object which will assign 
						      						  // a threadStastic object for each thread 
		
		}finally{
			
			this.cslock.unlock();//release the lock
		}
		
		// while loop for processing the string objects in the queue and updating the attributes of each thread
		while(!this.strQueue.isEmpty()){
		
			this.cslock.lock(); // get a lock to accesses the collection and the update methods . All incoming treads will have to wait  here
			
			String str = (String) this.strQueue.dequeue();
			
			/**
			 *  This condition will be handled when the last element in the queue was processed, and a waiting thread got
			 *  in the critical section after checking the loop's condition before it become false.
			 *  to prevent the thread form running to a null exception the lock has to be released and the loop must break.
			 *   normally that means every String object was processed.
			 */
			
			if(str==null){
				
				this.cslock.unlock();
				break;
					}
				
			// The normal flow of execution continues from here
			else{
				
			 length += getStringVaule(str);// update the length using the getStringVaule which returns an integer value
			 totalCount++;				   // update the count by +1
				
			// call the updateTs method using ThreadLocal object and pass the total Count and the length to update the average and the count of 
			 //each thread's private area that is stored in a queue inside the ThreadStatsticSetup class.
			this.threadss.get().updateTs(totalCount, length);;
			
			this.cslock.unlock();// release the lock 
		
				  }
		}
	}
	
	
	
	/**
	 * a method that takes a string, process it's length and return an Integer value
	 * @param str
	 * @return integer
	 */
	
	public int getStringVaule(String str){
		
		int value = 0;
		for (int index = 0; index < str.length(); index++) {
		value = value + str.charAt(index) - 'a';}
		
		return value;
	}
}
