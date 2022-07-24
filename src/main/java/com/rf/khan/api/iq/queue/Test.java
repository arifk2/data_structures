package com.rf.khan.api.iq.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
	public static void main(String[] args) {
		// Example 1
		int arr1[] = new int[] { -8, 2, 3, -6, 10 };
		int k1 = 2;
		firstNegativeInteger(arr1, k1);
		// Example 2

		int arr2[] = new int[] { 7, 9, -1, 2, 3, 4, -2, -3, -4 };
		int k2 = 3;
		firstNegativeInteger(arr2, k2);

	}

	private static void firstNegativeInteger(int[] arr, int k) {
		Queue<Integer> q = new LinkedList<>();

		// for the first k window 0-k
		for (int i = 0; i < k; i++) {
			// if the first element is negative then store the index in stack
			if (arr[i] < 0) {
				q.add(i);
			}
		}

		// store the first negative number or print
		if (!q.isEmpty())
			System.out.print(arr[q.peek()] + " ");
		else
			System.out.print("0" + " ");

		// Now for the remaining kth's
		for (int i = k; i < arr.length; i++) {
			// condition to remove the element present in the queue
			while (!q.isEmpty() && q.peek() <= (i - k)) {
				q.poll();
			}
			if (arr[i] < 0)
				q.add(i);

			if (!q.isEmpty())
				System.out.print(arr[q.peek()] + " ");
			else
				System.out.print("0" + " ");
		}
		System.out.println();
	}
}
