package javaCollections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class JavaCollections {

	public static void main(String[] args) {
		Product door = new Product("Wooden Door", 35);
		Product floorPanel = new Product("Floor Panel", 25);
		Product window = new Product("Glass Window", 15);
		
		Collection<Product> products = new ArrayList<>();
		products.add(door);
		products.add(floorPanel);
		products.add(window);
		
		//System.out.println(products);
		
		//instead of this now we use foreach
		final Iterator<Product> productIterator = products.iterator(); 
		while(productIterator.hasNext()) { 
			Product product = productIterator.next();
			//the else check to remove object can't be implemented with foreach
			if(product.getWeight() > 20)
			{
				System.out.println(product); 
			}
			else
			{
				productIterator.remove();
			}
		}
		System.out.println(products);
		System.out.println(products.size());
		System.out.println(products.isEmpty());
		System.out.println(products.contains(window));
		System.out.println(products.contains(door));
		
		Collection<Product> otherProduct = new ArrayList<>();
		otherProduct.add(door);
		otherProduct.add(window);
		
		products.removeAll(otherProduct);
		
		System.out.println(products);
		 
		/*
		 * for (Product product : products) { System.out.println(product); }
		 */

	}

}
