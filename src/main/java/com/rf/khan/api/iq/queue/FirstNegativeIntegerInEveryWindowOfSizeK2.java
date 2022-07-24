package com.rf.khan.api.iq.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class FirstNegativeIntegerInEveryWindowOfSizeK2

{
	public static void main(String[] args) {
		// Example 1
		int arr1[] = new int[] { -8, 2, 3, -6, 10 };
		int k1 = 2;
		firstNegativeInteger(arr1, k1);
		// Example 2

		int arr2[] = new int[] { 7, 9, -1, 2, 3, 4, -2, -3, -4 };
		int k2 = 3;
		firstNegativeInteger(arr2, k2);

		long arr3[] = new long[] { -8, 2, 3, -6, 10 };
		System.out.println(printFirstNegativeIntegerT(arr3, 5, 2));

	}

	public static List<Long> printFirstNegativeIntegerT(long[] A, int N, int k) {
		List<Long> ans = new LinkedList<>();
		Queue<Integer> q = new LinkedList<>();

		// for the first k window 0-k
		for (int i = 0; i < k; i++) {
			// if the first element is negative then store the index in stack
			if (A[i] < 0) {
				q.add(i);
			}
		}

		// store the first negative number or print
		if (!q.isEmpty())
			ans.add(A[q.peek()]);
		else
			ans.add((long) 0);

		// Now for the remaining kth's
		for (int i = k; i < A.length; i++) {
			// condition to remove the element present in the queue
			while (!q.isEmpty() && q.peek() <= (i - k)) {
				q.poll();
			}
			if (A[i] < 0)
				q.add(i);

			if (!q.isEmpty())
				ans.add(A[q.peek()]);
			else
				ans.add((long) 0);
		}
		return ans;
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
