package com.rf.khan.api.iq.binary.complete.binary.tree;

import java.util.PriorityQueue;

public class KthLargest {

	public static int kthSmallest(int[] arr, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

		// Step1: create a max heap from the first kth element in the array
		for (int i = 0; i < k; i++) {
			maxHeap.add(arr[i]);
		}
		int tracker = k;

		while (tracker < arr.length) {
			if (maxHeap.peek() < arr[tracker]) {
				maxHeap.poll();
				maxHeap.add(arr[tracker]);
			}
			tracker++;
		}

		return maxHeap.peek();
	}

	public static void main(String[] args) {
		int arr[] = { 7, 10, 4, 20, 15 };
		System.out.println("Kth Largest element is: " + kthSmallest(arr, 2));
	}

}
