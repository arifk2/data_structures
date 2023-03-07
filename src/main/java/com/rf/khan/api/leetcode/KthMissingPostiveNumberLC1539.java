package com.rf.khan.api.leetcode;

import java.util.HashSet;
import java.util.Set;

public class KthMissingPostiveNumberLC1539 {
	public static void main(String[] args) {
		KthMissingPostiveNumberLC1539 k = new KthMissingPostiveNumberLC1539();
		System.out.println(k.findKthPositiveBS(new int[] { 2, 3, 4, 7, 11 }, 5));
		System.out.println(k.findKthPositive(new int[] { 1, 2, 3, 4 }, 2));
	}

	private int findKthPositiveBS(int[] arr, int k) {
		int low = 0;
		int high = arr.length;

		while (low < high) {
			int mid = (high - low) / 2 + low;
			if (arr[mid] - (mid + 1) >= k) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low + k;
	}

	public int findKthPositive(int[] arr, int k) {
		// step 1 : Add all element in the set data structure
		Set<Integer> set = new HashSet<>();
		for (int ar : arr)
			set.add(ar);

		// Step: start iterator from 1 and if element is present then increment the
		// iterator, else decrement k and increment iterator
		int it = 1;
		while (k > 0) {
			if (set.contains(it)) {
				it++;
			} else {
				k--;
				it = it + 1;
			}
		}
		return it - 1;
	}
}
