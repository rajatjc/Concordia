// SimpleLinkedList.java
//
// One way to build a list is by created a linked collection of node objects.
// The code below implements a linked list in this manner. 

// The node class. Each node contains a value object, plus a reference to the last 
// and next nodes in the list.
class ListNode{
	
	private Object value;
	private ListNode next;
	private ListNode previous;
	
	public ListNode(Object value){
		this.value = value;
		next = null;
		previous = null;
	}
	
	public void setValue(Object value){
		this.value = value;
		next = null;
		previous = null;
	}
	
	public Object getValue(){
		return value;
	}
	
	public void setNext(ListNode next){
		this.next = next;
	}
	public ListNode getNext(){
		return next;
	}
	
	public void setPrevious(ListNode previous){
		this.previous = previous;
	}
	public ListNode getPrevious(){
		return previous;
	}
	
}




//The SimpleLinkedList class. Note that it implements the SimpleList interface.
public class SimpleLinkedList implements SimpleList{

	ListNode head; // pointer to start of list
	ListNode tail; // pointer to end of list
	int currentSize;
	
	
	// constructor
	public SimpleLinkedList(){
		head = null;
		tail = null;
		currentSize = 0;
	}
	
	//	 constructor
	public SimpleLinkedList(ListNode head){
		this.head = head;
		this.tail = head;
		currentSize = 1;
	}
	
	public int getSize(){
		return currentSize;
	}
	
	
	// retrieve an object at a specific index
	public Object getObjectAt(int index){
		
		ListNode target;
		
		if (index > currentSize - 1)
			throw (new SimpleListIndexOutOfBoundsException());
		
		target = getNode(0, index, head);
		return target.getValue();
	}
	
	
	// set an object at a specific index
	public void setObjectAt(int index, Object thing){
		
		ListNode target;
		
		if (index > currentSize - 1)
			throw (new SimpleListIndexOutOfBoundsException());
		
		target = getNode(0, index, head);
		target.setValue(thing);
		
	}
	
	
	// add a new object to the list at a specific index. Care must be taken to 
	// adjust all references sappropriately
	public void insertObjectAt(int index, Object thing){
		
		if (index > currentSize - 1)
			throw (new SimpleListIndexOutOfBoundsException());
		
		ListNode target, previous;
		ListNode newNode = new ListNode(thing);
		
		target = getNode(0, index, head);
		
		//	handle a few special cases
		if (index == 0)
			head = target;
		
		previous = target.getPrevious();
		if (previous != null)
			previous.setNext(newNode);
		
		target.setPrevious(newNode);
		
		newNode.setPrevious(previous);
		newNode.setNext(target);
		
		currentSize += 1;
		
		
	}
	
	
	// delete an object from the list at a specific index. Care must be taken to 
	// adjust all references sappropriately
	public void deleteObjectAt(int index){
	
		if (index > currentSize - 1)
			throw (new SimpleListIndexOutOfBoundsException());
	
	
		ListNode target, previous, next;
		
		target = getNode(0, index, head);
		
		// handle a few special cases
		if (index == (currentSize - 1))
			tail = tail.getPrevious();
		if (index == 0)
			head = head.getNext();
		
		// now delete the object
		previous = target.getPrevious();
		next = target.getNext();
		
		if (previous != null)
			previous.setNext(next);
		
		if (next!= null)
			next.setPrevious(previous);
		
		currentSize -= 1;
	
	}
	
	
	// add a node to the end of the list
	public void append(Object thing){
		
		ListNode newNode = new ListNode(thing);
		
		if (currentSize == 0)
			head = tail = newNode;
		else{
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = newNode;
		}
			
		currentSize += 1;
	
	}
	
	
	// a recursive method to find a node at a specific index position. Though
	// recursion can be used for this purpose, it's probably a bad idea. If
	// the list is long the recursion can exhaust the stack space and cause 
	// a run-time error.
	/*
	 protected ListNode getNode(int current, int selected, ListNode node){
		if (current == selected)
			return node;
		
		return getNode(current + 1, selected, node.getNext());
	} */
	
	
	// a simple iterative technique to find the node at a given index. It is
	// superior to the recursive method in that it is easy to write and it
	// does not exhoust the stack.
	protected ListNode getNode(int current, int selected, ListNode node){
		
		while(current != selected){
			node = node.getNext();
			current += 1;
		}
		
		return node;
	}
	
	
	// a test program
	public static void main(String[] args) {
	
		Integer myInt;
		SimpleLinkedList myList = new SimpleLinkedList();
		
		System.out.println("Appending 20 and 23 to a list of size 2...");
		myList.append(new Integer(20));
		myList.append(new Integer(23));
		
		System.out.println("Show the list");
		for (int i = 0; i < myList.getSize(); i++){
			myInt = (Integer)myList.getObjectAt(i);
			System.out.println(myInt.intValue());
		}
		System.out.println("Size = " + myList.getSize());
		
		System.out.println("\nAppending 14 and 36 to the same list...");
		myList.append(new Integer(14));
		myList.append(new Integer(36));
		
		System.out.println("Show the list");
		for (int i = 0; i < myList.getSize(); i++){
			myInt = (Integer)myList.getObjectAt(i);
			System.out.println(myInt.intValue());
		}
		System.out.println("Size = " + myList.getSize());
		
		System.out.println("\nSetting the value at position 3 to 99 and deleting object at position 1");
		myList.setObjectAt(3, (new Integer(99)));
		myList.deleteObjectAt(1);
		System.out.println("Show the list");
		for (int i = 0; i < myList.getSize(); i++){
			myInt = (Integer)myList.getObjectAt(i);
			System.out.println(myInt.intValue());
		}
		System.out.println("Size = " + myList.getSize());
		
		System.out.println("\nInserting the numbers 88, 87, 86, 85, 84 at position 1...");
		myList.insertObjectAt(1, (new Integer(88)));
		myList.insertObjectAt(1, (new Integer(87)));
		myList.insertObjectAt(1, (new Integer(86)));
		myList.insertObjectAt(1, (new Integer(85)));
		myList.insertObjectAt(1, (new Integer(84)));
		System.out.println("Show the list");
		for (int i = 0; i < myList.getSize(); i++){
			myInt = (Integer)myList.getObjectAt(i);
			System.out.println(myInt.intValue());
		}
		System.out.println("Size = " + myList.getSize());
		

		
		System.out.println("\nCreating a new list of size 2 and appending four animals...");
		SimpleLinkedList myList2 = new SimpleLinkedList();
		myList2.append("dog");
		myList2.append("cat");
		myList2.append("bird");
		myList2.append("racoon");
		System.out.println("Show the list");
		for (int i = 0; i < myList2.getSize(); i++){
			System.out.println( (String)myList2.getObjectAt(i));
		}
		System.out.println("Size = " + myList2.getSize());
		
		
		//	myList.setObjectAt(16, (new Integer(99)));
		
	}
	
}
