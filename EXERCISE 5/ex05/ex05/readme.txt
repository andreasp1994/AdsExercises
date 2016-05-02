
Exercise 5: Sorting, an empirical study
Purpose: to gain experience of implementing sorting algorithms 
         to gain insight based on empirical study
         to get a feel for h/w performance and effect of algorithms


What difference does 50 years make?
-----------------------------------
We have two pdf documents in this directory. The paper p312-wegstein is CACM 6 (6) 1963
where reported is Algorithm 175, Shuttle Sort. This is in fact bubble sort. In the paper
p619-wegstein CACM 6 (10) we have an empirical study for shuttle sort, i.e. Certification
of Algorithm 175. Given are run times of bubble sort on a Burroughs B220 with data sets
of size 25 to 500 and run times are reported in seconds.

Answer the following questions:

  (a) Repeating the experiments with your own bubble sort, how much faster 
      is your machine in comparison with the B220?
  (b) In CACM 6 (10) 25 items were sorted in 1.6 seconds, 50 in 6.2 seconds and 100 
      in 25.8 seconds. What data set sizes can you bubble sort in 1.5 seconds, 6 seconds, 
      25 seconds? Based on this, again, how much faster are we compared to the B220? 
      NOTE: be aware that the algorithm is quadratic complexity! Therefore if we sort a data 
      set of size (let's say) 1,000 in 1.6 seconds does that mean we are 20 times faster or 
      does it mean we are (1,000 * 1,000)/(50*50) = 400 times faster?
  (c) Implement pigeonhole (bucket) sort and radix sort and compare these to bubble sort.
      How much speedup can we get from the algorithms, and do they scale as predicted by
      theory (java's Array.sort is quicksort and that is O(n.log n), radix is O(d.n)
      and pigeonhole O(n))?
  (d) How much of a "dollar speedup" have we achieved over the last 50 years?


What to do:

 1. Make a directory and down load the files in this directory (you are here)

 2. Modify the file Sort.java
     - implement bubbleSort
     - implement radixSort
     - implement pigeonholeSort

 3. run your programs on the command line, for example
 
    > java Sort arrays 100000 999999999

    will generate an array of 100,000 integers in the range 0 to 999,999,999, sort them using java's 
    in-built sort routine, and output the number of milliseconds taken by the call Arrays.sort

    > java Sort arrays 20 100 true

    will generate an array of 20 random integers in the range 0 to 99, sort them using Arrays.sort
    and outputs the sorted array. NOTE: only use for debugging and when n is small

    > java Sort bubble 100 1000

    does a bubble sort on 100 random integers in the range 0 to 999

    > java Sort radix 20 100000

    does a radix sort on 20 numbers in the range 0 to 999,999

    > java Sort pigeon 1000 100
    
    does a pigeonhole (bucket) sort on 1,000 numbers in the range 0 to 99

   > java -Xmx1G Sort jsort 100000000 10000

   increase run time space to 1Gb and then sorts 100,000,000 integers in the range 0 to 9,999
   using Arrays.sort(A)

 
 4. Perform experiments comparing runtimes over different sized data sets and
    data sets with numbers in different ranges, and answer the questions above.
 
Hints and Tips
--------------
 (a) In radixSort it may be useful to implement (and test) a private method
     that takes two integers n and d and delivers the dth digit of n
 (b) You might implement (and test) a method that finds the largest number
     in the data set and delivers the number of digits in that number
 (c) you would call the method in (b) once only
 (d) Paranoid? I am. I always check as much as I can. Are you sure your code
     actually sorts the data? Maybe write code to test this, or use the command line flag
 (e) In pigeonholeSort create an array of ArrayList<Integer> and sort the data in
     the array A into that, then scan the array of ArrayList<Integer>, and scan
     each ArrayList<Integer> to refill the array A.
 (f) ... but since we are sorting integers and everything in a bucket is the same, do we
     really need a bucket? Could we just build up counters on the occurrences of numbers?
 (g) Yes, we ain't daft. We know there's code out there on the web. Write your own
     code! That way you will learn something useful and have some fun too!
 (h) ... and there are slides in this directory to help you.
 (i) ... and there are even more hints in Hints.java
 (j) Cost information: in 1960
      - B220 cost between $640,000 and $1,200,000
      - median family income was $6,000 per year
      - minimum hourly wage $1.25
      - a gallon of petrol $0.25
      - McDonalds hamburger $0.20
      - movie ticket $0.50


Patrick Prosser
