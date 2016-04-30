import java.io.*;
import java.util.*;

public class Heap <E extends Comparable<E>> {
 
    private Object H[];   // contains the objects in the heap
    private int last;     // index of last element in heap
    private int capacity; // max number of elements in heap  

    public Heap(int n){
	capacity = n;
	H        = new Object[capacity+1];
	last     = 0;
    }
    //
    // create a heap with capacity n
    // NOTE: H is an array of objects
    //       must use casting when delivering the minimum
    //       See min() below.
    //       This must also be done in removeMin()
    //

    public Heap(){this(7);}
    //
    // by default, create a new heap with capacity 7
    //

    @SuppressWarnings("unchecked")
    private int compare(Object x,Object y){return ((E)x).compareTo((E)y);}
    
    public int size(){return last;}
    //
    // returns the number of elements in the heap
    //
    
    public boolean isEmpty(){return last==0;}
    //
    // is the heap empty?
    //
    
    @SuppressWarnings("unchecked")
    public E min() throws HeapException {
	if (isEmpty()) throw new HeapException("underflow");
	return (E) H[1];
    }
    //
    // returns element with smallest key, without removal
    // NOTE: must use casting to class (E)
    //
	
    private void swap(int i, int j){
		Object temp = H[i];
		H[i] = H[j];
		H[j] = temp;
	}
	//
	//	Swaps nodes with specified indexes
	//
	
	private int getLeftIndex(int i) { return i*2; }
	private int getRightIndex(int i) { return i*2+1; }
	private int getParentIndex(int i) { return i/2; }
	
	private boolean hasLeft(int i){ return getLeftIndex(i)<=last ; }
	private boolean hasRight(int i){ return getRightIndex(i)<=last; }
	
	private Object getLeft(int i){ return H[getLeftIndex(i)]; }
	private Object getRight(int i){ return H[getRightIndex(i)]; }
	private Object getParent(int i) { return H[getParentIndex(i)]; }
	
	private boolean isRoot(int i) { return i == 1; }
	
	private boolean isHeap(){ return isHeap(1); }
	private boolean isHeap(int i) {
	
		if (hasLeft(i)){
			if(compare(getLeft(i),H[i]) >= 0) return isHeap(getLeftIndex(i));
			System.out.println("Index: " + getLeftIndex(i) + " " + getLeft(i) + " < Index: " + i + " " + H[i]);
			return false;
		}
		
		if (hasRight(i)){
			if(compare(getRight(i),H[i]) >= 0) return isHeap(getRightIndex(i));
			System.out.println(getRight(i) + " < " + H[i]);
			return false;
		}
		return true;
	}
	
	private int findMinIfExists(int i){
		if (getLeftIndex(i) > size()) return -1;
		else if (getRightIndex(i) > size()) return (compare(H[getLeftIndex(i)],H[i]) < 0) ? getLeftIndex(i) : -1;
		else if (compare(getLeft(i),H[i]) > 0 && compare(getRight(i),H[i])> 0) return -1;
		else if (compare(H[getLeftIndex(i)],H[getRightIndex(i)]) < 0) return getLeftIndex(i);
		else return getRightIndex(i);
	}
	
	private void upheapBubble(int i){
		if (!isRoot(i) && compare(getParent(i),H[i]) > 0) {
			swap(getParentIndex(i),i);
			upheapBubble(getParentIndex(i));
		}
	}
	
	private void downHeapBubble(int i) {
		int min = findMinIfExists(i);
		if (min != -1) {
			swap(i,min);
			downHeapBubble(min);
		}	
	}
	
    public void insert(E e) throws HeapException {
	if (size() == capacity ) throw new HeapException("overflow");
	int index = last + 1;		//NOTE: parent = index / 2
	H[index] = e;
	last++;
	upheapBubble(index);
	
	//while(!isRoot(index)) {
	//	if (compare(getParent(index), H[index]) < 0) break;
	//	swap(getParentIndex(index),index);
	//	index = getParentIndex(index);
	//}
	}
    //
    // inserts e into the heap
    // throws exception if heap overflow
    //
    
    @SuppressWarnings("unchecked")
    public E removeMin() throws HeapException {
	if (isEmpty()) throw new HeapException("underflow");
	E temp = min();
	H[1] = H[last];
	H[last] = null;
	last--;
	downHeapBubble(1);
	return temp;
    }
    //
    // removes and returns smallest element of the heap
    // throws exception if heap is empty
    // NOTE: must cast result to class (E)
    //       see min() above
    //

    public String toString(){
		String out = "[";
		if (!isEmpty()) out += H[1].toString(); //add first element to string variable
		for (int i = 2;i<=size();i++){	//skip first cause it was added above
			out = out + ',' + H[i];
		}
		out += "]";
		return out;
    }
    //
    // outputs the entries in H in the order H[1] to H[last]
    // in same style as used in ArrayQueue
    // 
    // 
    
}

