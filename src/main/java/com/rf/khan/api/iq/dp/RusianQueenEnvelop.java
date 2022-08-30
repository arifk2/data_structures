package com.rf.khan.api.iq.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class RusianQueenEnvelop {

	/**
	 * Solving problem using dp and binary Search
	 * 
	 * * TC = O(n Log N)
	 * 
	 * * SP = O(n)
	 * 
	 * @param envelopes
	 * @return
	 */
	public static int maxEnvelopes(int[][] envelopes) {
		sortArray(envelopes);

		int n = envelopes.length;
		return solveUsingDPBinarySearch(envelopes, n);
	}

	/**
	 * This method is created to sort the width in ascending order, if the width is
	 * equal then sort by width in descending.
	 * 
	 * @param envelopes
	 * @param col
	 */
	private static void sortArray(int[][] envelopes) {
		Arrays.sort(envelopes, new Comparator<int[]>() {

			@Override
			public int compare(int[] first, int[] second) {
				if (first[0] == second[0]) {
					return Integer.compare(second[1], first[1]);
				} else {
					return Integer.compare(first[0], second[0]);
				}
			}
		});
	}

	/**
	 * Solving using dp + binary search tree
	 * 
	 * @param envelopes
	 * @param n
	 * @return
	 */
	private static int solveUsingDPBinarySearch(int[][] envelopes, int n) {

		if (n == 0)
			return 0;
		Vector<Integer> ans = new Vector<>();
		ans.add(envelopes[0][1]);

		for (int i = 1; i < n; i++) {
			if (envelopes[i][1] > ans.lastElement()) {
				ans.add(envelopes[i][1]);
			} else {
				int index = upperBound(ans, envelopes[i][1]);
				ans.set(index, envelopes[i][1]);
			}
		}

		return ans.size();
	}

	/**
	 * This method is created to found the just greater element than key
	 * 
	 * @param envelopes
	 * @param key
	 * @return
	 */
	private static int upperBound(Vector<Integer> height, int key) {

		int index = Collections.binarySearch(height, key);
		// if not found
		if (index < 0) {
			return Math.abs(index) - 1;
		}
		return index;
	}

	/**
	 * This is driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] envelopes = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
		System.out.println(maxEnvelopes(envelopes));
	}
}
