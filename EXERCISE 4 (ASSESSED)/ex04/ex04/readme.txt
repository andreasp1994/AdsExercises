
      Exercise 4: Heap<E>  (ASSESSED)
      -------------------------------

Description:
-------------
Implement a priority queue using the Heap data structure, then use this to sort a file of text


How a Heap works
----------------
The Heap data structure has an array H, an integer  capacity, and last (the position of the last entry) 
The array H runs from H[0] right up to H[capacity+1], so that

      - the 1st element of the heap is in H[1]
      - the last element of the heap is in H[last]

The heap property is that given an element H[i] 

      - the element to the left of H[i] is greater than or equal to H[i], 
      - the element to the right of H[i] is greater than or equal to H[i]

The elements of H can be viewed as a binary tree, numbered in the conventional way
 
      - the element to the left of H[i] is H[i*2]
      - the element to the right of H[i] is H[i*2 + 1]
      - the parent of H[i] is H[i/2]


What needs to be done:
---------------------
Implement the following methods in the class Heap.java

    public int size(){...}
    //
    // returns the number of elements in the heap
    //
    
    public boolean isEmpty(){...}
    //
    // is the heap empty?
    //
    
    public void insert(E e) throws HeapException {...}
    //
    // inserts e into the heap, maintaining the heap property
    // throws HeapException if heap overflow
    //
    
    public E removeMin() throws HeapException {...}
    //
    // removes and returns smallest element of the heap, maintaining the heap property
    // throws HeapException if heap is empty
    // NOTE: you must cast the result to E, so look at code for min()
    //

    public String toString(){...}
    //
    // outputs the entries in S in the order H[1] to H[last]
    // in same style as used in ArrayQueue
    //

Modify HeapSort.java so that the program outputs sorted data, one word per line.

Getting started:
----------------
 1. Make a directory to work in and then copy across all files
    in this directory (including this one).

 2. Compile all the java files
    - javac *.java

 3. Run the Test program to allow testing of your code
    - java Test

 4. Modify Heap.java, implementing the methods required

 5. Test your program and run the Marker class to get an idea of how you are doing
    - java HeapMarker

 6. When you are satisfied with your work, submit your file Heap.java via MOODLE
    NOTE: a compressed, zipped or rar file will NOT be accepted and will not be marked

 7. Move on to HeapSort.java and then when happy with your results submit your
    file HeapSort.java via MOODLE
    NOTE: a compressed, zipped or rar file will NOT be accepted and will not be marked


Hints and Tips
--------------
1. You need to do "up heap bubbling" and "down heap bubbling".
2. You will be, in some sense, implementing a complete binary tree within the array H. 
   So, what is left and what is right and what is parent? Maybe implement private methods 
   to get the element to the left/right/parent of i.
3. It might help to have private methods hasLeft(), hasRight(), and swap(i,j)
4. When you compare entries in the heap use the private method compare(x,y).
5. Belts and braces? To debug/develop, how about a method isHeap, that checks that the heap 
   property is present? You might run this after an insertion or deletion to make
   sure everything is okay. You might also corrupt H so that you can confirm that isHeap() 
   actually detects absence of the heap property! But remember to remove that code before submitting!
6. Checking things out? Use Test, create a new small heap so that you can try and break it
   or go to the boundaries quickly.
7. Forgotten how a Heap works? Have a look at the lecture slides or the book, or run Heap.jar.


Patrick Prosser
  
