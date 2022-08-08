package com.rf.khan.api.iq.binary.complete.binary.tree;

/**
 * 0 based index
 * 
 * @author mkhan339
 *
 */
public class MinHeapSortCS {

	public static int[] buildMinHeap(int[] arr) {
		int n = arr.length;
		for (int i = (n / 2) - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}
		return arr;
	}

	/**
	 * Heapify to build min heap
	 * 
	 * @param arr
	 * @param n
	 * @param i
	 */
	public static void heapify(int[] arr, int n, int i) {
		int smallest = i;

		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && arr[smallest] > arr[left]) {
			smallest = left;
		}
		if (right < n && arr[smallest] > arr[right]) {
			smallest = right;
		}
		if (smallest != i) {
			// swap it
			int temp = arr[smallest];
			arr[smallest] = arr[i];
			arr[i] = temp;
			heapify(arr, n, smallest);
		}
	}
}
