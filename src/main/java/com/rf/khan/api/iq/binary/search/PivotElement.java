package com.rf.khan.api.iq.binary.search;

public class PivotElement {

	public static void main(String[] args) {
		// sorted and rotated array
		int[] input = { 3, 8, 10, 17, 1 };
		int[] innput2 = { 7, 9, 1, 2, 3 };
		System.out.println(pivotIndex(input));
		System.out.println(pivotIndex(innput2));

	}

	public static int pivotIndex(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		int mid = start + (end - start) / 2;
		while (start < end) {
			if (arr[mid] >= arr[0]) {
				start = mid + 1;
			} else {
				end = mid;
			}
			mid = start + (end - start) / 2;
		}
		return start;
	}
}
