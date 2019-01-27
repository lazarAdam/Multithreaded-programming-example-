/**
 * This class store both the count and the average length for each string was processed
 * @author Oussama
 *
 */
public class ThreadStatistic {

	private int count;
	
	private int avg;
	
	private  long threadId;
	
	
	/**
	 * getter and setter methods for thread id 
	 * @return
	 */
	
	public long getThreadId() {
		return threadId;
	}

	public void setThreadId(long threadId) {
		this.threadId = threadId;
	}

	/**
	 * a getter for the count of strings
	 * @return
	 */
	public int getCount() {
		return count;
	}

/**
 * a setter for the count of strings
 * @param count
 */
	public void setCount(int count) {
		this.count = count;
	}


/**
 * a getter for the average length of strings
 * @return
 */
	public int getAvg() {
		return avg;
	}

/**
 * a setter for the average length of strings
 * @param avg
 */
	public void setAvg(int avg) {
		this.avg = avg;
	}

	/**
	 *  to string method for the object
	 *  
	 */
	public String toString() {
		return "Threaad "+this.threadId+" [count=" + count + ", avg=" + avg + "]";
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
