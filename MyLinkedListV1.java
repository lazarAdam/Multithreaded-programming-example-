/**
 * @author Oussama El aallali
 * 
 *  This class interprets a generic linked List, that can be
 *  used to make collections of data and store it connected set of nodes
 * 
 * 
 * invariant: 
 *  linked list class uses the  ComputerParts class
 * node class uses the linked list class 
 * head and tail are data fields of type node form the node class
 * head is always pointing at the head of the list
 * tail is always pointing at the tail of the list  unless if one of them is null 
 * nodes are always linked together staring at head going to tail as the last node in the list
 * the class insure that a list is created in order and it should remain ordered
 * the size of the list is always refers to the exact number of nodes that are in the list 
 * 
 */

public class MyLinkedListV1<E> {

	
	
private  Node head;

private Node tail;


/**
 * Constructor of the linked list 
 */

public MyLinkedListV1(){
	
	this.head = null;
	this.tail = null;
	
}

/**
 * Getter method for head node 
 * @return head node 
 * @post return the object of node head 
 * 
 */

public Node getHead() {
	return head;
}


/**
 * Getter method for tail node 
 * @return tail node 
 * @post return the object of node tail 
 * 
 */
public Node getTail() {
	return tail;
}



/**
 * add an element at the head of the list
 * @param data
 */
public void addAtHead(Object data){
	

	
	head = new Node( data, head);
	
	if (head.getNext() == null){
		
		tail = head;
	}
}

/**\
 * add an an element at the tail of the list
 * @param data
 */
public void addAtTail(Object data){
	
	if (tail == null){
		tail = new Node (data , null);
		
		head = tail;
		
		
	}

		
	else{	
	tail.setNext(new Node (data , null));
	
	tail = tail.getNext();
	}
	
	
}


/**
 * Remove and return an element from the head of the list
 * @return
 */
public Object removeFromHead(){
	
	Object cp = head.getData();
	
	head = head.getNext();
	
	return cp;
}

public boolean isempty(){
	
	return head == null;	
}


/**
 * the method traverse the linked list using the node cursor and count how many nodes are in the list
 * @return answer as an integer value of how many nodes in the list
 * 
 *@post return the integer value that present the size of the list  
 */
public int sizeOFList(){
	
Node  cursor = head;

int answer = 0;

while (cursor != null){
	
	cursor = cursor.getNext();
	
	answer++;
	
	
}
return answer;
	
}

/**
 * the toString() method traverse the list and collect the strings of the data members 
 *  and add them into one string
 * @return one string that present each object that exists inside a node
 * 
 * @post return a single string representation of the data in the list
 * 
 */


public String toString(){
	
	String s = " ";
	
	Node cursor = head; 
	
	
	while(cursor != null ){
		
		s+=cursor.getData() + "\n";
		
		cursor = cursor.getNext();
		
	}
	
	return s;
	
}

}


