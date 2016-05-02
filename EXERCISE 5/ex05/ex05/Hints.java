//
// Code below might be cut & paste and help you get started.
//
import java.util.*;

public class Hints {


    private static int numberOfDigitsIn(int n){return (int)Math.log10((double)n) + 1;}
    //
    // Given a decimal number n, how many digits are there in n?
    //

    private static int getDthDigit(int n,int d){
	for (int i=0;i<d;i++) n = n / 10;
	return n % 10;
    }
    //
    // give me the dth digit of decimal number n
    // NOTE: getDthDigit(857,0) would deliver 7
    //       getDthDigit(857,1) would deliver 5
    //       getDthDigit(857,3) would deliver 0
    //

    @SuppressWarnings("unchecked")
    private static void radixSort(int[]A){
	ArrayList<Integer>[] bucket = new ArrayList [10];                       // (1)
	for (int i=0;i<10;i++) bucket[i] = new ArrayList<Integer>();            // (2)
        int maxDigits = -999;                                                   // (3)
                                                                                //  ...
    }                                                                           // (6)
    //
    // radix sort the array of n integers A
    // (1) numbers are decimal so we have 10 buckets
    // (2) create the 10 buckets
    // (3) find the number of digits of the largest number in A
    // (4) now sort numbers in A by the ith digit, starting at least significant digit
    // (4.1) for each integer in A
    // (4.1.1) get the ith digit of the number, call it digit, and then ...
    // (4.1.2) put that number into the bucket for that digit, i.e. bucket[digit]
    // (4.4) now transfer the data in the buckets back into A
    // (4.4.1) get the numbers in bucket[k] and copy back to array A, and then ...
    // (4.4.2) clear out that bucket
    //

    @SuppressWarnings("unchecked")
    private static void pigeonholeSort(int[] A){
	int n = A.length;                                                   // (1)        
        int m = -999;                                                       // (2) 
                                                                            // (3)
	ArrayList<Integer>[] bucket = new ArrayList[m+1];                   // (4a)
	for (int i=0;i<=m;i++) bucket[i] = new ArrayList<Integer>();        // (4b)
                                                                            // (5)
                                                                            // (6)
    }
    //
    // pigeonhole sort, aka bucket sort ... 
    // (1) to (3) get largest number in A and call it m
    // (4a) produce m+1 buckets, bucket[0] to bucket[m], 
    // (4b) where a bucket is an ArrayList of integers
    // (5) for every integer i in A, add i to bucket[i]
    // (6) recreate A, sorted!
    //

}