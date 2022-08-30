package com.rf.khan.api.iq.dp;

import java.util.Collections;
import java.util.Vector;

public class LongestIncreasingViaBinarySearchTree {
	// Function to find length of longest increasing subsequence.
	static int longestSubsequence(int size, int a[]) {
		return solveUsingBST(a, size);
	}

	/**
	 * Solving using binary search tree
	 * 
	 * @param a input array
	 * @param n
	 * @return
	 */
	private static int solveUsingBST(int[] a, int n) {
		if (n == 0)
			return 0;

		Vector<Integer> ans = new Vector<>();
		ans.add(a[0]);

		for (int i = 1; i < n; i++) {

			if (a[i] > ans.lastElement()) {
				ans.add(a[i]);
			} else {
				// find index of just bada element in the ans
				int index = upperBound(ans, a[i]);
				ans.set(index, a[i]);
			}
		}
		return ans.size();
	}

	/**
	 * This method is created to found the just greater element than key
	 * 
	 * @param arr
	 * @param key
	 * @return
	 */
	private static int upperBound(Vector<Integer> arr, int key) {
		// Collections.sort(arr);

		int index = Collections.binarySearch(arr, key);
//		// if key is not present in the array
		if (index < 0)
			return Math.abs(index) - 1;

		return index;
//		// if key is present in the array
//		else {
//			while (index > 0) {
//
//				// If previous value is same
//				if (arr.get(index - 1) == key)
//					index--;
//
//				// Previous value is different which means
//				// current index is the first occurrence of
//				// the key
//				else
//					return index;
//			}
//			return index;
		// }
	}

	public static void main(String[] args) {
		int[] a = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		int size = a.length;
		System.out.println(longestSubsequence(size, a));
	}
}
