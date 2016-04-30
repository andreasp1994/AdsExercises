
                    Exercise 2: QueueSort<E>
                    -------------------------


Description:
-----------
We can merge two sorted queues. Assume we have ArrayQueue<E> Q1 and Q2, both sorted in 
ascending order. We can then create a third ArrayQueue Q3 (of size Q1.size() + Q2.size())
such that all the data in Q1 and Q2 is merged in ascending order into Q3, using the dequeue
and enqueue methods. This can be done in time O(Q1.size() + Q2.size()).

We can exploit merging to sort a data set. For example, given N strings we could create N 
ArrayQueue<String> each containing one of the strings. We then create a queue of queues,
i.e. an ArrayQueue<ArrayQueue<String>> Q of size N. We then enqueue each of our N queues
of size 1. We can then sort the N strings by dequeueing the first two ArrayQueue<String> in Q, 
call these Q1 and Q2, merging them to get a new ArrayQueue<String> Q3, and then enqueueing Q3 
on Q. We repeat this until Q.size() == 1, and then we are done. 

Using the ArrayQueue<E> class implement an QueueSort<E> class that does sorting as above. Your
class should take parameterised types so that we can sort String, Integer, ..., in fact anything
that is comparable. Your class should contain a main method that picks up a file name
from the command line, reads the file as strings and then outputs the file sorted in lex order.


What needs to be done: 
---------------------
In the QueueSort.java file implement the methods that are 
commented as // IMPLEMENT THIS. 


Getting started:
----------------
 1. Use the same directory as in part 1 of this exercise, and copy across all
    of the files.

 2. Implement the necessary methods in QueueSort.java and then compile
    - javac *.java

 3. Run the program 
    - java QueueSort fname
    where fname is a file of strings such as one of the data sets 
    data17.txt, data2415.txt or data25104.txt

 4. When you are satisfied with your work, submit your file QueueSort.java via MOODLE

What you should learn:
---------------------
You should learn about using parametrised types, sorting, using your own code.


Patrick Prosser