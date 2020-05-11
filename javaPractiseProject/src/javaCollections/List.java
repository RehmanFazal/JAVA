package javaCollections;

import java.util.ArrayList;

public class List {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		ArrayList list2 = new ArrayList();
		
		list.add("Ali");
		list.add("Ali");
		list.add("Shoaib");
		list.add("Abdullah");
		list.add("Maria");
		list.add("Aliya");
		
		list2.add(1);
		list2.add(2.2);
		list2.add("Ali");
		
		System.out.println(list);
		System.out.println(list.contains("Ali"));
		System.out.println(list2);
		String name = list.get(2);
		System.out.println(name);
		//object is parent of all obj and as per polymorphism parent can access obj 
		//of child
		Object o = list2.get(1);
		System.out.println(o);
		
		list.set(2, "Laiba");
		
		list.remove(1);
		
		System.out.println(list);
	}
	
}
