package com.rf.khan.api.iq.queue;

import java.util.Deque;
import java.util.LinkedList;

class FirstNegativeIntegerInEveryWindowOfSizeK {

	private static void firstNegativeInteger(int[] arr, int k) {
		int n = arr.length;
		// create a deque q
		Deque<Integer> q = new LinkedList<>();
		// traverse the first window
		for (int i = 0; i < k; i++) {
			// if the current element is negative add it to the end of deque
			if (arr[i] < 0)
				q.addLast(i);
		}
		// if deque is not empty, front of deque is the index of first negative element
		// else there is no negative element in this window
		if (!q.isEmpty())
			System.out.print(arr[q.peek()] + " ");
		else
			System.out.print("0 ");

		for (int i = k; i < n; i++) {
			// remove previous window elements
			while (!q.isEmpty() && q.peek() <= (i - k)) {
				q.removeFirst();
			}
			// if the current element is negative, add it to the deque
			if (arr[i] < 0)
				q.addLast(i);
			// if deque is not empty, front of deque is the index of first negative element
			// else there is no negative element in this window
			if (!q.isEmpty())
				System.out.print(arr[q.peek()] + " ");
			else
				System.out.print("0 ");
		}
		System.out.println();
	}

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
}