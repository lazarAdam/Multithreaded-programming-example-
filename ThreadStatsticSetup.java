/**
 * @author Oussama
 *
 * This class allow each thread to store its private section  
 * as a ThreadStatstic object to a queue, treated as the private area of each tread
 */
public class ThreadStatsticSetup {

	//  queue used to store ThreadStatistic object for each thread
	private  static  LinkedQueue<ThreadStatistic> privatearea = new LinkedQueue<ThreadStatistic>();
	private ThreadStatistic ts;
	
	/**
	 * constructor takes an object of  ThreadStatistic and adds it to the private area queue
	 * @param object
	 */
	public ThreadStatsticSetup(){
		
		
		ts = new ThreadStatistic();
		
		privatearea.enqueue(ts);
		
	}
	
	/**
	 * Update both the count and for each object in the private queue 
	 * @param count
	 * @param len
	 */
	public void updateTs(int count, int len){
		
		this.ts.setCount(count);
		
		this.ts.setAvg(len / count);	
		
	}
	
	/**
	 * print the content of the queue, by calling the toString of each  ThreadStatistic object processed by a thread 
	 */
	public static void print(){
		
		int tid=1;
		
		
	while(!privatearea.isEmpty()){
		
		ThreadStatistic object = (ThreadStatistic) privatearea.dequeue(); // creating a reference of ThreadStatistic object from the next object in the queue 
		
		object.setThreadId(tid++); // setting the thread id to a value before printing
		
		System.out.println(object.toString());
		
	}
		
	}
}
