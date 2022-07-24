package com.rf.khan.api.iq.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseKth {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>(Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }));
		System.out.println(q);
		System.out.println(modifyQueue(q, 3));
	}

	/**
	 * This method is created to reverse the queue;
	 * 
	 * @param q
	 * @param k
	 * @return
	 */
	public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {

		// Step1: create a stack and put kth element in the stack
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < k; i++) {
			int val = q.peek();
			q.poll();
			stack.push(val);
		}

		// Step2: put all the element from the stack to queue
		while (!stack.isEmpty()) {
			int val = stack.peek();
			stack.pop();
			q.add(val);
		}
		int t = q.size() - k;
		while (t > 0) {
			int val = q.peek();
			q.poll();
			q.add(val);
			t--;
		}
		stack = null;

		return q;
	}
}
