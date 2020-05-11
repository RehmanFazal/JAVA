package javaCollections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class JavaSet {

	public static void main(String[] args) {
		// Unique elements
		
		//follow no order
		Set<String> set = new HashSet<>();
		set.add("a");
		set.add("bgfd");
		set.add("c54");
		set.add("d54");
		set.add("eyyt");
		set.add("a");
		
		System.out.println(set);
		
		//follow order
		
		Set<String> set1 = new LinkedHashSet<>();
		set1.add("a");
		set1.add("bgfd");
		set1.add("c54");
		set1.add("eyyt");
		set1.add("eyyt");
		set1.add("hhggt");
		
		System.out.println(set1);
		
		//follow natural order i.e for string alphabatic order and for integer number order
		
		Set<String> set2 = new TreeSet<>();
		set2.add("a");
		set2.add("bgfd");
		set2.add("c54");
		set2.add("hjhgfg");
		set2.add("eyyt");
		set2.add("eyyt");
		
		System.out.println(set2);
	}

}
