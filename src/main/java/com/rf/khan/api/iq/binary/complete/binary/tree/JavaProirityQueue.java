package com.rf.khan.api.iq.binary.complete.binary.tree;

import java.util.Collections;
import java.util.PriorityQueue;

public class JavaProirityQueue {

	public static void main(String[] args) {
		PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
		p.add(4);
		p.add(2);
		p.add(5);
		p.add(3);

		System.out.println(p.peek());
		p.poll();
		System.out.println(p.peek());
	}
}
