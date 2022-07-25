package com.rf.khan.api.iq.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InterleaveUsingStack {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>(Arrays.asList(new Integer[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 }));
		System.out.println(q);
		interLeaveQueue(q);
		System.out.println("Queue " + q);
	}

	public static void interLeaveQueue(Queue<Integer> q) {
		int size = q.size() / 2;
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < size; i++) {
			stack.push(q.poll());
		}

		while (!stack.isEmpty()) {
			q.add(stack.pop());
		}

		for (int i = 0; i < size; i++) {
			q.add(q.poll());
		}

		for (int i = 0; i < size; i++) {
			stack.push(q.poll());
		}

		while (!stack.isEmpty()) {
			q.add(stack.pop());
			q.add(q.poll());
		}
	}
}
