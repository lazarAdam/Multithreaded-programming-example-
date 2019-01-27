/**
 * @author Oussama el aallali
 *
 * this is a generic implementation of the  Node class the supply a node object to 
 * the linkedList class 
 */
public class Node<E> {
	
	private Object data;
	private Node next;
	
	/**
	 * construct a node with two cells data and the the reference to the next node 
	 * @param data
	 * @param nextNode
	 */
	public Node(Object data, Node nextNode){
		
		
		this.data= data;
		this.next = nextNode;
		
	}
	
	
/**
 * getter for the data in a node
 * @return data
 */
	public Object getData() {
		return data;
	}

/**
 * setter for data in a node
 * @param data
 */
	public void setData(Object data) {
		this.data = data;
	}


/**
 * get the reference to the next node 
 * @return next
 */
	public Node getNext() {
		return next;
	}

	/**
	 * set the reference to the next node 
	 * @return next
	 */
	public void setNext(Node next) {
		this.next = next;
	}

	/**
	 * compareTo method implementation for the node class 
	 * @param data
	 * @return
	 */
	public int mycompareTo(String data){
		
		return (data.compareToIgnoreCase(data));
	}

	
}
