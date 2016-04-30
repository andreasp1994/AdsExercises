/** Singly linked list with just a head storing strings*/
public class IntLinkedList {

    private Node head;  //head node of the list
    private long size;  //number of nodes in the list
    
    /** Default constructor that creates an empty list */
    public StringList(){head=null; size=0;}

    /** add node to front of list containing the String s */
    public void addFront(String s){
	head = new Node(s,head);
	size++;
    }
	
    /** return the size of the list */
    public long size(){return size;}
	
    /** return the head of the list*/
    public Node getHead(){return head;}
	
    /**is the list empty?*/
    public boolean isEmpty(){return head == null;}	
	
    /** remove node from front of list */
    public void removeFirst() throws ListException {
	if (!isEmpty()){head = head.getNext(); size--;}
	else throw new ListException("attempted removal from an empty list");
    }
	
    /** is the string s in the list? */
    public boolean isPresent(String s){
	Node cursor = head;
	while(cursor != null){
	    if (cursor.getElement().equals(s)) return true;
	    cursor = cursor.getNext();
	}
	return false;
    }
	
    /** Add new value in non-decreasing order into list */
    public void insert(String s){                             // <0>
	if (head == null || head.compareTo(s) > 0)            // <1>
	    head = new Node(s,head);                          // <2>
	else {                                                // <3>
	    Node cursor = head;                               // <4>
	    Node next = cursor.getNext();                     // <5>
	    while (next != null && next.compareTo(s) <= 0 ){  // <6>
		cursor = next; next = next.getNext();         	  // <7>
	    }                                                 // <8>
	    cursor.setNext(new Node(s,next));                 // <9>
	}                                                     // <10>
	size++;                                               // <11>
    }
    //
    // <0> insert string in lex order into list
    // <1> consider empty list or s should be in 1st position
    // <3> non-empty list with s not in 1st position
    // <4> we use two pointers, cursor and next (next = cursor.getNext())
    // <6> we iterate until we hit end of list or encounter an element greater than s
    //     and then we need to insert s in that position
    // <9> we add a new element after the cursor, with next as new element's "tail"
    //<11> well, we did add a new element!!
    //
	
	
    /** remove all nodes containing element with a given value */
    public void remove(String s){
	Node cursor = head;
	Node prev   = null;
	while(cursor != null){
	    if(cursor.compareTo(s) == 0){
		if (cursor == head) removeFirst();
		else {prev.setNext(cursor.getNext());size-=1;}}
	    else prev = cursor;
	    cursor = cursor.getNext();
	}
    }
	
    /** String representation of list */
    public String toString(){
	Node cursor = head;
	String s = "(";
	while(cursor != null){
	    s = s + cursor;
	    cursor = cursor.getNext();
	    if (cursor != null) s = s + ",";
	}
	return s + ")";
    }

    //
    // Exercise 1 code below
    // Implement the following functions
    //
    //    - equal
    //    - reverse
    //    - count
    //    - get
    //    - last
    //    - append
    //    - indexOf
    //    - replace
    //

    public boolean equal(StringList l){
	Node cursorl1 = this.head;
	Node cursorl2 = l.getHead();
	if(this.size == l.size()){
		while(cursorl1 != null){
		if(!cursorl1.getElement().equals(cursorl2.getElement())){return false;}
		cursorl1 = cursorl1.getNext();
		cursorl2 = cursorl2.getNext();
		}
		return true;
	}
	return false;
	}
    //
    // l1.equals(l2) delivers true if the two lists
    // contain the same elements in the same order
    //
    
    public StringList reverse(){
	Node cursor = this.head;
	StringList sl = new StringList();
	while (cursor != null){
		sl.addFront(cursor.getElement());
		cursor = cursor.getNext();
	}
	return sl;
	}
    // 
    // l.reverse() delivers a new StringList that has the 
    // the elements of l in reverse order
    //
    
    public String get(int i){
	Node cursor = this.head;
	if(!(i < 0 || i >= this.size)){
		for(int r =0;r<i;r++){
			cursor = cursor.getNext();
		}
		return cursor.getElement();
	}
	return "";
	}
    //
    // l.get(i) delivers a String s, the ith element of list l.
    // If i is negative or i is greater than or equal to l.size() deliver ""
    // Note: l.get(0) delivers the 1st element of the list (if there is one)
    //

    public Node last(){
	Node cursor = this.head;
	for(int i = 0;i<this.size-1;i++){
		cursor = cursor.getNext();
	}
	return cursor;
	}
    // 
    // l.last() delivers the last Node in the list l.
    // Note: this might be used when appending lists
    //
    
    public void append(StringList l){
		this.last().setNext(l.getHead());
	}
    //
    // l1.append(l2) append list l2 to the end of list l1.
    // Note: this operation modifies l1, such that the last
    //       Node in l1 points to the head of l2.
    //       You should investigate the consequences of this
    //		(size does not change)

    public int count(String s){
	int counter = 0;
	Node cursor = head;
	while( cursor != null){
		if (cursor.getElement().equals(s)) {counter++;}
		cursor = cursor.getNext();
	}
	return counter;
	}
    //
    // l.count(s) returns the number of times s occurs in l
    //

    public int indexOf(String s){
	int index = 0;
	Node cursor = this.head;
	while(cursor != null){
		if (cursor.getElement().equals(s)){return index;} 
		index++;
		cursor = cursor.getNext();
	}
	return -1;
	}
    //
    // indexOf(s) returns -1 if s is not in the list, otherwise
    // the index of the first occurrence of s in the list
    //

    public void replace(String s1,String s2){
	Node cursor = this.head;
	while( cursor != null){
		if (cursor.getElement().equals(s1)){cursor.setElement(s2);}
		cursor = cursor.getNext();
	}
	}
    //
    // replace all occurrences of s1 with s2
    // NOTE: you need to use setElement
    //
}
