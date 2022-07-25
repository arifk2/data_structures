package com.rf.khan.api.iq.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class InterleaveUsingQueue {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>(Arrays.asList(new Integer[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 }));
		System.out.println(q);
		interLeaveQueue(q);
		System.out.println(q);
	}

	public static void interLeaveQueue(Queue<Integer> q) {
		int size = q.size() / 2;
		Queue<Integer> newQ = new LinkedList<>();
		for (int i = 0; i < size; i++) {
			newQ.add(q.poll());
		}

		while (!newQ.isEmpty()) {
			q.add(newQ.poll());
			q.add(q.poll());
		}
	}
}
