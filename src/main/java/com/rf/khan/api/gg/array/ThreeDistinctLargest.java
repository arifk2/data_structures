package com.rf.khan.api.gg.array;

import java.util.Arrays;

public class ThreeDistinctLargest {
	void find3largest(int[] arr) {
		Arrays.sort(arr); // It uses Tuned Quicksort with
		// avg. case Time complexity = O(nLogn)
		int n = arr.length;
		int check = 0, count = 1;

		for (int i = 1; i <= n; i++) {

			if (count < 4) {
				if (check != arr[n - i]) {
					// to handle duplicate values
					System.out.print(arr[n - i] + " ");
					check = arr[n - i];
					count++;
				}
			} else
				break;
		}
	}

	// Driver code
	public static void main(String[] args) {
		ThreeDistinctLargest obj = new ThreeDistinctLargest();
		int[] arr = { 12, 45, 1, -1, 45, 54, 23, 5, 0, -10 };
		obj.find3largest(arr);
	}
}