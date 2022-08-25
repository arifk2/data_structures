package com.rf.khan.api.gg.array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallest {
	public static void main(String[] args) {
		int[] arr = { 12, 3, 5, 7, 20, 19, 25 };
		int k = 2;
		int n = arr.length;
		// System.out.println(kthSmallest(arr, k));
		// System.out.println(kthLargest(arr, k));
		// System.out.println(kLargest(arr, n, k));
		kLargestMinHeap(arr, n, k);
	}

	/**
	 * Kth smallest
	 * 
	 * * Time Complexity: O(N log N)
	 * 
	 * * Auxiliary Space: O(1)
	 * 
	 * @param arr
	 * @return
	 */
	public static int kthSmallest(int[] arr, int k) {
		Arrays.sort(arr);
		return arr[k - 1];
	}

	public static int kthLargest(int[] arr, int k) {
		Arrays.sort(arr);
		return arr[arr.length - 2];
	}

	static int[] kLargest(int[] arr, int n, int k) {
		Integer[] obj_array = Arrays.stream(arr).boxed().toArray(Integer[]::new);

		int[] ans = new int[k];
		Arrays.sort(obj_array, java.util.Collections.reverseOrder());
		for (int i = 0; i < k; i++) {
			ans[i] = obj_array[i];
		}
		return ans;
	}

	static void kLargestMinHeap(int[] a, int n, int k) {
		// a Priority Queue
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		for (int i = 0; i < n; ++i) {

			// Insert elements into
			// the priority queue
			pq.add(a[i]);

			// If size of the priority
			// queue exceeds k
			if (pq.size() > k) {
				pq.poll();
			}
		}

		// Print the k largest element
		while (!pq.isEmpty()) {
			System.out.print(pq.peek() + " ");
			pq.poll();
		}
		System.out.println();
	}
}
