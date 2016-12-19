//This driver brought to you by Don Landrum
import java.util.*;
public class KonigsTest {
	public static void main(String[] args) {
		Konigsberg test = new Konigsberg();
		System.out.println("Adding seven historic bridges to the land-masses of Konigsberg");
		test.addEdge(1);
		test.addEdge(2);
		test.addEdge(3);
		test.addEdge(4);
		test.addEdge(5);
		test.addEdge(6);
		test.addEdge(7);
		Set<Integer> s = new HashSet<Integer>();
	    s.add(1);
	    s.add(2);
	    s.add(3);
	    s.add(4);
	    s.add(5);
	    s.add(6);
	    s.add(7);
	    System.out.println("Finding all possible orders in which a person could walk across the bridges");
	    test.permutations(s, new Stack<Integer>(), s.size());
	    System.out.println("Testing each possible order for whether it meets the requirements of the problem");
	    if(test.traverse()==true){
	    	System.out.println("After checking every possible route, I have determined that it IS possible to walk each bridge exactly once.");
	    }
	    else{
	        System.out.println("After checking every possible route, I have determined that it is NOT possible to walk each bridge exactly once.");
	    }
	}
}