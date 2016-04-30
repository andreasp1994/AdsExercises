import java.util.*;
import java.io.*;

public class HeapSort {
    
    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new File(args[0]));
	ArrayList<String> data = new ArrayList<String>();
	while (sc.hasNext()) data.add(sc.next());
	
	Heap<String> heapData = new Heap<String>(data.size());
	for( String item : data) heapData.insert(item);
	while (!heapData.isEmpty()) System.out.println(heapData.removeMin());
    }
}
//
// takes a filename from the command line
// and outputs that file sorted, one word per line
//
