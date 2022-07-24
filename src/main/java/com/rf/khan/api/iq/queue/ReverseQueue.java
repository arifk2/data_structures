package com.rf.khan.api.iq.queue;

import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
	// Function to reverse the queue.
	public Queue<Integer> rev(Queue<Integer> q) {
		Stack<Integer> stack = new Stack<Integer>();
		if (q.isEmpty()) {
			return q;
		}
		while (!q.isEmpty()) {
			int element = q.peek();
			q.poll();
			stack.push(element);
		}

		while (!stack.isEmpty()) {
			int element = stack.peek();
			stack.pop();
			q.add(element);
		}
		return q;
	}
}