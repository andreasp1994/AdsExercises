
                    Exercise 2: ArrayQueue<E>
                    -------------------------

Description:
-----------
You are to implement a "circular" queue using an array. For information on
how to do this you should look at the text book, "5.2.2 A Simple Array-Based
Queue Implementation". However, your implementation will differ in one important
respect. In the book version "... we ... insist that Q can never hold more than N-1 objects".
We will insist that "... Q can hold no more than N objects", and a simple way to do this is to 
have a size attribute within the ArrayQueue data structure. In addition your ArrayQueue<E> is
parameterised so that we can create and ArrayQueue of any type <E> (and this will be tested).

How an ArrayQueue works
-----------------------
We have an array of objects Q and integers front and rear (initially both zero). 
We create the array Q to be of size n (consequently if we try and add/enqueue
more than n objects we get an overflow exception). The item at the front of
the queue is Q[front] and the first free space in the queue is Q[rear]. Therefore 
we remove (dequeue) elements of type <E> from the front of the queue and add 
(enqueue) elements of type <E> at the rear of the queue.

We can think of the Q as something like a clock face, where when we reach 12 o'clock
we move on to 1 o'clock, or in our case if we have rear = n-1 and we add one more element
then rear is increased modulo n (it goes to zero). Similarly, when we dequeue an element 
we increment front, again modulo n. Initially front = rear = 0 and the size of the queue is zero.

If we attempt to put more than n items in the queue your code should throw an 
exception "Queue overflow" and if there is an attempt to dequeue (or look at the front of)
an empty queue then throw an exception "Queue underflow".


What needs to be done: 
---------------------
You need to implement the class ArrayQueue.java and the methods that are 
commented as // IMPLEMENT THIS. In particular, implement the following methods 
in ArrayQueue.java These are described more fully in the file ArrayQueue.java

    public ArrayQueue(){...}

    public ArrayQueue(int capacity){...}
	
    public int size(){...}
	 
    public boolean isEmpty(){...}

    public E front() throws ArrayQueueException {...}
	
    public void enqueue(E element) throws ArrayQueueException {...}    }
    
    public E dequeue() throws ArrayQueueException {...}
    
    public String toString(){...}


Getting started:
----------------
 1. Make a directory to work in and then copy across all files
    in this directory (including this one).

 2. Compile all the java files
    - javac *.java

 3. Run the Test program
    - java Test

 4. Modify ArrayQueue.java, implementing the methods marked as // IMPLEMENT THIS
    - implement methods one at a time
    - recompile and run the Test program (3) above
    - iterate till done

 5. Test and mark your program by running the Marker class
    - java ArrayQueueMarker

 6. When you are satisfied with your work, submit your file ArrayQueue.java via MOODLE
    and proceed to the second part (in readmeB.txt)


Hints and Tips
--------------
(a) Have a look at the text book, be familiar with modulo arithmetic, have a look at ArrayStack
    source code that we have on our course web pages.

(b) Have a look at the slides in this directory QueuesCircular.ppt

(c) Keep it simple!

(d) To debug your code you might want to edit Test.java and keep the queue small.
    Also, you can put print statements in your code, BUT REMOVE BEFORE YOU SUBMIT

(e) Without doubt the toString method is non-trivial, so here are some specific hints
    - you want to iterate from i equal to the front of the queue
    - each step you increment i modulo n
    - you do this size times (but don't alter size!)
    - nuff said

What you should learn:
---------------------
You should learn about the circular queue, using parametrised types, modulo arithmetic,
testing code, throwing exceptions, ...


Patrick Prosser