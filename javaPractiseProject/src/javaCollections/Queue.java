package javaCollections;

import java.util.PriorityQueue;

public class Queue {
	public static void main(String[] args) {
		PriorityQueue<Integer> queue =  new PriorityQueue<Integer>();
		for (int i = 10; i > 0; i--) {
			queue.add(i);
		}
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue.peek());
		System.out.println(queue.size());
	}
}
