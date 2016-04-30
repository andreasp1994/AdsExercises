import java.util.*;

public class Test {
    
    public static void main(String[] args) throws Exception {

	String commands = "\nHeap Tester (version 20160222) \n" +
                      "insert (+), remove (-), empty (e), size \n" + 
                      "min, new, show, help, quit (q)";

	System.out.println(commands);
	
	Scanner sc = new Scanner(System.in);	
	Heap<String> H = new Heap<String>();
	String s;
	System.out.print("> ");

	String command = sc.next();
	while (!command.equals("quit") && !command.equals("q")){
		if (command.equals("help")) System.out.println(commands);		
		if (command.equals("size")) System.out.println(H.size());		
		if (command.equals("empty") || command.equals("e")) System.out.println(H.isEmpty());		
		if (command.equals("new")){
		    System.out.print("new Heap size? >> ");
		    int n = sc.nextInt();
		    H = new Heap<String>(n);
		}		
		if (command.equals("insert") || command.equals("+")){
		    System.out.print(">> ");
		    s = sc.next();
		    H.insert(s);
		}		
		if (command.equals("remove") || command.equals("-")){
		    s = H.removeMin();
		    System.out.println(s);
		}		
		if (command.equals("min")) System.out.println(H.min());
		if (command.equals("show")) System.out.println(H.toString());

		System.out.println("size: "+ H.size() +" "+ H);

		System.out.print("> ");
		command = sc.next();
	    }
    }
}
