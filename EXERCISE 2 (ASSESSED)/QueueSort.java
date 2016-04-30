import java.util.*;
import java.io.*;

public class QueueSort<E extends Comparable<E>> {

    private ArrayQueue<ArrayQueue<E>> Q;
    public static final int CAPACITY = 10;  // default queue capacity
    private int n;    
    private boolean trace;
	
    public QueueSort(){this(CAPACITY);}
	
    public QueueSort(int capacity){
		n = capacity;
		Q = new ArrayQueue<ArrayQueue<E>>(n);
    }

	
    private ArrayQueue<E> merge(ArrayQueue<E> q1,ArrayQueue<E> q2) throws ArrayQueueException {
		
		int totalCapacity = q1.size() + q2.size();
		ArrayQueue<E> mergedQueue = new ArrayQueue<E>(totalCapacity);
		
		//Check if any of the array queues is empty.
		E e1;
		E e2; 
		if (!q1.isEmpty()) e1 =  q1.dequeue();
		else return q2;
		if (!q2.isEmpty()) e2 =  q2.dequeue();
		else return q1;
		
		while(mergedQueue.size() != totalCapacity){
			if (e1.compareTo(e2) < 0) {
				mergedQueue.enqueue(e1); 
				if(!q1.isEmpty()) { e1 = q1.dequeue(); }
				else {
					//Add remaining elements
					mergedQueue.enqueue(e2);
					while (!q2.isEmpty()){
						mergedQueue.enqueue(q2.dequeue());
					}
				}
			} else { 
				mergedQueue.enqueue(e2);
				if(!q2.isEmpty()) { e2 = q2.dequeue(); }
				else {
					//Add remaining elements
					mergedQueue.enqueue(e1);
					while (!q1.isEmpty()){
						mergedQueue.enqueue(q1.dequeue());
					}
				}
			}
		}
		
		
		return mergedQueue;
    }
    //
    // Take two sorted queues and merge them to produce a third
    // sorted queue
    //

    public void sort(){
		while(Q.size() != 1 ) {
			Q.enqueue(merge(Q.dequeue(),Q.dequeue()));
		}
	}
    // given a queue Q of queues
    // (1) if Q is of size 1 deliver the first queue in Q
    // (2) if Q is of size 2 or more 
    //     - get the first and second queues off Q
    //     - merge these two queues to create a third queue
    //     - add the third queue to the queue
    //     - go back to (1)
    //

    public void add(E element){
		ArrayQueue<E> queue = new ArrayQueue<E>(1);
		queue.enqueue(element);
		Q.enqueue(queue);
	}
    // create an ArrayQueue<E> that contains the element
    // enqueue it onto Q
    //
    
    public String toString(){return Q.toString();}

    public void trace(){trace = !trace;}

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new File(args[0]));
	ArrayList<String> data = new ArrayList<String>();
	while (sc.hasNext()) data.add(sc.next());
	int n = data.size();
	QueueSort<String> QS = new QueueSort<String>(n);
	for (String s : data) QS.add(s);
	//System.out.println(QS.toString());
	if (args.length > 1) QS.trace();
	QS.sort();
	System.out.println(QS);
    }
}
