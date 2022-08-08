package com.rf.khan.api.iq.binary.complete.binary.tree;

import java.util.Arrays;

public class MergeHeapMax {

	public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
		// Step1: merge both the arrays into one;
		int size = n + m;
		int[] ans = new int[size];

		System.arraycopy(a, 0, ans, 0, n);
		System.arraycopy(b, 0, ans, n, m);

		// Step2: build heap using merged array: heapify

		for (int i = size / 2 - 1; i >= 0; i--) {
			heapify(ans, i, size);
		}
		System.out.println(Arrays.toString(ans));
		return ans;
	}

	public void heapify(int[] ans, int i, int n) {
		int largest = i;

		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && ans[largest] < ans[left])
			largest = left;
		if (right < n && ans[largest] < ans[right])
			largest = right;

		if (largest != i) {
			// swap it
			int temp = ans[largest];
			ans[largest] = ans[i];
			ans[i] = temp;

			// call heapify to correct its position
			heapify(ans, largest, n);
		}
	}

	public static void main(String[] args) {
		int n = 4, m = 3;
		int a[] = { 10, 5, 6, 2 };
		int b[] = { 12, 7, 9 };

		MergeHeapMax merge = new MergeHeapMax();
		merge.mergeHeaps(a, b, n, m);

	}
}
