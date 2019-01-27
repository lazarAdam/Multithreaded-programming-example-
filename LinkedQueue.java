/**
 * @author 	Oussama El aallali
 * 
 * Generic implementation of a Queue using the concept of linked lists 
 * 
 * 
 */
public class LinkedQueue<E> {

	private MyLinkedListV1 Lqueue;
	
	
	/**
	 * instantiate an object of MyLinkedListV1
	 */
	public LinkedQueue (){
		
		Lqueue = new MyLinkedListV1();
		
	}
	
	/**
	 *  add an object to the queue 
	 * @param data
	 */
	public void enqueue(Object data){
		
		Lqueue.addAtTail(data);
			
	}
	/**
	 * remove an object from the queue
	 * @return
	 */
	public Object dequeue(){
		
		if(!this.isEmpty())
			
			return(Lqueue.removeFromHead());
		else
			return null;
	}
	
	/**
	 * checks if the queue has any elements in it
	 * @return
	 */
	public boolean isEmpty(){
		
		return(Lqueue.sizeOFList()==0);
		
	}
	/**
	 * returns the size of the queue
	 * @return
	 */
	public int GetCurSizeOfQeue(){
		
		
		
		return this.Lqueue.sizeOFList();
		}
	
	
}
