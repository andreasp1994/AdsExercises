import java.util.*;

public class Sort {

	private static int MAX_NUMBER;

	private static void swap(int[] A,int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	private static int numberOfDigitsIn(int n){return (int)Math.log10((double)n) + 1;}
    //
    // Given a decimal number n, how many digits are there in n?
    //

    private static int getDthDigit(int n,int d){
	for (int i=0;i<d;i++) n = n / 10;
	return n % 10;
    }

    private static void bubbleSort(int[] A){
		for (int i = 0;i<A.length;i++){
			boolean swaped = false;
			for( int j = A.length-1 ;j > i;j--){
				if (A[j] < A[j-1]) {
					swap(A, j,j-1);
					swaped = true;
				}					
			}	
			if (swaped = false) return; 
		}
	}

	/**
	Used for Radix Sort. 
	**/
	private static void addToBucket(int[] A, Integer digitpos, LinkedList<Integer>[] buckets){
		for (int n : A){
			int digit = getDthDigit(n,digitpos);
			buckets[digit].add(n);
		}
	}
	
	/**
	Used for Radix Sort.
	**/
	private static void removeFromBuckets(int[] A, LinkedList<Integer>[] buckets){
		int i = 0;
		for (LinkedList<Integer> b: buckets){
			while(!b.isEmpty()){
				A[i] = b.removeFirst();
				i++;
			}
		}
	}
	
	//Used for debugging
	private static void printBuckets(LinkedList<Integer>[] buckets){
		for(int i =0;i<buckets.length;i++){
			System.out.print(i + ":");
			while(!buckets[i].isEmpty()){
				System.out.println(n+",");
			}
			System.out.println();
		}
	}
	
    @SuppressWarnings("unchecked")
    private static void radixSort(int[]A){
		//Max digits
		int maxDigits = numberOfDigitsIn(MAX_NUMBER);
	
		// Create buckets
		// Use LinkedList because ArrayList's add operation runs in amortized constant time, that is, adding n elements requires O(n) time
		// Recall : if arraylist needs more space it has to resize itself. On the contrary, linked list dynamically allocates space.
		LinkedList<Integer>[] buckets = new LinkedList[10];                      
		for (int i=0;i<10;i++) buckets[i] = new LinkedList<Integer>();            
		
		//For each digit, add to bucket and remove from bucket
		for(int n = 0;n<=maxDigits;n++){
			addToBucket(A,n,buckets);
			removeFromBuckets(A,buckets);
		}
    }                                                                           

	@SuppressWarnings("unchecked")
    private static void pigeonholeSort(int[] A){
	
	int min = A[0];
	int max = A[0];
	for(int i = 1;i<A.length;i++){
		if (A[i]>max) max = A[i];
		if (A[i]<min) min = A[i];
	}
	
	int range = max - min + 1;
	// Use LinkedList because ArrayList's add operation runs in amortized constant time, that is, adding n elements requires O(n) time
	// Recall : if arraylist needs more space it has to resize itself. On the contrary, linked list dynamically allocates space.
	LinkedList<Integer>[] pigeonholes = new LinkedList[range];
	for(int i = 0;i<range;i++) pigeonholes[i] = new LinkedList<Integer>();
	
	for(int n : A){
		pigeonholes[n - min].addLast(n);
	}
	
	int index = 0;
	for (int i = 0 ;i<range;i++){
		if (!pigeonholes[i].isEmpty())
			A[index++] = pigeonholes[i].removeLast();
	}
	
	}

    public static void main(String[] args){
	String command = args[0];                   // algorithm name
	int n          = Integer.parseInt(args[1]); // number of numbers
	int m          = Integer.parseInt(args[2]); // biggest number in data
	MAX_NUMBER = m;
	Random gen     = new Random();
	int[] A        = new int[n];
	for (int i=0;i<n;i++) A[i] = gen.nextInt(m);
	if (args.length > 3){
	    for (int x : A) System.out.print(x +" ");
	    System.out.println();
	}
	long startTimeMs = System.currentTimeMillis();
	if (command.equals("arrays")) Arrays.sort(A);
	else if (command.equals("bubble")) bubbleSort(A);
	else if (command.equals("radix")) radixSort(A);
	else if (command.equals("pigeon")) pigeonholeSort(A);
	else if (command.equals("jsort")) Arrays.sort(A);
	else {System.out.println("invalid command"); return;}
	long elapsedTimeMs = System.currentTimeMillis() - startTimeMs;
	System.out.println("time (ms): "+ elapsedTimeMs);
	if (args.length > 3){
	    for (int x : A) System.out.print(x +" ");
	    System.out.println();
	}
    }
}
