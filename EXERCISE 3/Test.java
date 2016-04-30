import java.util.*;
import java.io.* ;

public class Test {      
    
    public static void main(String[] args) throws Exception, FileNotFoundException {
	
	String commands = "\nBTree Tester (version 20160212) \n" +
	                  "insert (+), delete (-), present (?), read, \n" +
	                  "preorder (pre), inorder (in), postorder (post), bfs, dfs, show, draw, \n" + 
	                  "height (h), size, clear, quit (q)";
	
	System.out.println(commands);
	Scanner sc = new Scanner(System.in);
	Scanner fin = null;
	
	System.out.print("> ");
	String command = sc.next();
	BSTree t1 = new BSTree();
	Graphic graphic = new Graphic(t1);
	String s = "";
	
	if (args.length > 0){
	    fin = new Scanner(new File(args[0]));
	    while (fin.hasNext()){s = fin.next(); t1.insert(s);}
	    fin.close();
	}

	while (!command.equals("quit") && !command.equals("q")){
	    
	    if (command.equals("help")) System.out.println(commands);

	    if (command.equals("size")) System.out.println(t1.size());
	    
	    if (command.equals("insert") || command.equals("ins") || command.equals("+")){
		System.out.print("insert >> ");
		s = sc.next();
		t1.insert(s);
		graphic.draw();
	    }

	    if (command.equals("read")){
		System.out.print("file name >> ");
		s = sc.next();
		fin = new Scanner(new File(s));
		while(!t1.isEmpty()) t1.delete(t1.root().getElement());
		while (fin.hasNext()){s = fin.next(); t1.insert(s);}
		fin.close();
		graphic.draw();
	    }

	    if (command.equals("delete") || command.equals("del") || command.equals("-")){
		System.out.print("delete >> ");
		s = sc.next();
		t1.delete(s);
		graphic.draw();
	    }

	    if (command.equals("present") || command.equals("pres") || command.equals("?")){
		System.out.print("present >> ");
		s = sc.next();
		System.out.println(t1.isPresent(s));
	    }

	    if (command.equals("height") || command.equals("h"))
		System.out.println(t1.height());

	    if (command.equals("preorder") || command.equals("pre")){t1.preorder(); System.out.println();}

	    if (command.equals("inorder") || command.equals("in")){t1.inorder(); System.out.println();}

	    if (command.equals("postorder") || command.equals("post")){t1.postorder(); System.out.println();}
	    
	    if (command.equals("bfs")) t1.bfs();

	    if (command.equals("dfs")) t1.dfs();
	    
	    if (command.equals("show")){System.out.println(t1);}
	    
	    if (command.equals("draw")){
		graphic.draw();
	    }

	    if (command.equals("clear")){
		while(!t1.isEmpty()) t1.delete(t1.root().getElement());
		graphic.draw();
	    }
	
	    System.out.print("> ");
	    command = sc.next();
	}
	System.exit(0);
    }
}
