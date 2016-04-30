import java.util.*;
import java.io.* ;

public class Test {      
         
 public static void main(String[] args) throws ArrayQueueException {

    String commands = "\nArrayQueue Tester (version 20160127) \n" +
	              "size, empty, front (f), enqueue (+), dequeue (-), show, quit (q), help";

    System.out.println(commands);
    Scanner sc = new Scanner(System.in);

    System.out.print("> ");
    String command = sc.next();
    ArrayQueue<String> Q = new ArrayQueue<String>(10);

    while (!command.equals("quit") && !command.equals("q")){

	if (command.equals("size")) System.out.println(Q.size());

	if (command.equals("empty")) System.out.println(Q.isEmpty());

	if (command.equals("front") || command.equals("f")) System.out.println(Q.front());

	if (command.equals("enqueue") || command.equals("+")){
	    System.out.print(">> ");
	    Q.enqueue(sc.next());
	}

	if (command.equals("dequeue") || command.equals("-")) System.out.println(Q.dequeue());

	if (command.equals("show")) System.out.println(Q);

	if (command.equals("help")) System.out.println(commands);
	
	System.out.println(Q +" size: "+ Q.size()); // show Q at end of loop
	System.out.print("> ");
	command = sc.next();
    }
 }
}
