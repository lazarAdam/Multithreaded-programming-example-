/**
 * running a test case for the program by 
 * creating random strings and put them into a queue
 * creating 5 threads and assigning them to the RequestProcess class and staring each thread for processing
 */
public class Driver {


	public static void main(String[] args) {


	
		 LinkedQueue<String> collection = new LinkedQueue<String>();
			
			
			for (int index = 0; index < 10000; index++) {
			int length = ((int) (Math.random() * 10000)) % 100;
			StringBuffer buffer = new StringBuffer();
			for (int count = 0; count < length; count++) {
			buffer.append((char) ((((int) (Math.random() * 10000)) % 26) + 'a'));
			}
			String newString = new String(buffer);
			collection.enqueue(newString);
			}
			

		
			RequestProcessor processor = new RequestProcessor(collection);
		
			
			int numberOfThreads = 5;
			Thread[] threads = new Thread[numberOfThreads];
			for (int index = 0; index < threads.length; index++) {
			threads[index] = new Thread(processor);
			threads[index].start();
			
			}
			
			
			try {
				
				for (int index = 0; index < threads.length; index++) {
				threads[index].join();
				
				
				}
				} catch(InterruptedException ie) {
				ie.printStackTrace();
				}
				ThreadStatsticSetup.print();
		
			
		
	}

}
